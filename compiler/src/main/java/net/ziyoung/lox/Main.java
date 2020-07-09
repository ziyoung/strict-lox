package net.ziyoung.lox;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.compiler.Compiler;
import net.ziyoung.lox.flag.Flag;
import net.ziyoung.lox.phase.Analyse;
import net.ziyoung.lox.phase.Generate;
import net.ziyoung.lox.phase.PreAnalyse;
import net.ziyoung.lox.phase.AnalyseContext;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.SymbolTable;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Flag flag = new Flag(args);
        flag.parse();
        if (!flag.isPassed()) {
            return;
        }

        Compiler compiler = new Compiler(flag.getFileName());
        CompilationUnit compilationUnit = compiler.parse();

        if (flag.isInspect()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("ast.json"), compilationUnit);
        }

        GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable();
        SemanticErrorList semanticErrorList = new SemanticErrorList();
        AnalyseContext analyseContext = new AnalyseContext(globalSymbolTable, semanticErrorList);

        PreAnalyse preAnalyse = new PreAnalyse(analyseContext);
        preAnalyse.visitCompilationUnit(compilationUnit);

        Analyse analyse = new Analyse(analyseContext);
        analyse.visitCompilationUnit(compilationUnit);

        System.out.println(globalSymbolTable.toString());
        if (!semanticErrorList.isEmpty()) {
            semanticErrorList.forEach(System.err::println);
            return;
        }

        Map<Node, SymbolTable> nodeSymbolTableMap = analyse.getNodeSymbolTableMap();
        ClassWriter classWriter = new ClassWriter(0);
        Generate generate = new Generate(analyseContext, nodeSymbolTableMap, classWriter);
        generate.visitCompilationUnit(compilationUnit);

        String classFileName = String.format("%s.class", compilationUnit.getQualifiedName());
        File file = new File(classFileName);
        if (file.createNewFile()) {
            System.out.println("create class file");
        }
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(classWriter.toByteArray());
        }

    }
}
