package net.ziyoung.lox;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.compiler.Compiler;
import net.ziyoung.lox.flag.Flag;
import net.ziyoung.lox.phase.Analyse;
import net.ziyoung.lox.phase.PreAnalyse;
import net.ziyoung.lox.phase.context.AnalyseContext;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.type.TypeChecker;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Flag flag = new Flag(args);
        flag.parse();
        if (flag.isPassed()) {
            Compiler compiler = new Compiler(flag.getFileName());
            CompilationUnit compilationUnit = compiler.parse();

            if (flag.isInspect()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValue(new File("ast.json"), compilationUnit);
            }

            GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable();
            SemanticErrorList semanticErrorList = new SemanticErrorList();
            TypeChecker typeChecker = new TypeChecker(globalSymbolTable, semanticErrorList);
            AnalyseContext analyseContext = new AnalyseContext(globalSymbolTable, semanticErrorList, typeChecker);

            PreAnalyse preAnalyse = new PreAnalyse(analyseContext);
            preAnalyse.visitCompilationUnit(compilationUnit);

            Analyse analyse = new Analyse(analyseContext);
            analyse.visitCompilationUnit(compilationUnit);

            System.out.println(globalSymbolTable.toString());
            if (semanticErrorList.size() != 0) {
                semanticErrorList.stream().forEach(System.err::println);
            }
        }
    }
}
