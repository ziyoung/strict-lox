package net.ziyoung.lox;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.flag.Flag;
import net.ziyoung.lox.compiler.Compiler;
import net.ziyoung.lox.phase.PreAnalyse;
import net.ziyoung.lox.phase.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

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
            PreAnalyse preAnalyse = new PreAnalyse(globalSymbolTable, semanticErrorList);
            preAnalyse.visitCompilationUnit(compilationUnit);

            if (semanticErrorList.size() != 0) {
                semanticErrorList.stream().forEach(System.err::println);
            }

            System.out.println(globalSymbolTable.toString());
        }
    }
}
