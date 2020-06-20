package net.ziyoung.lox;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.cmd.Cmd;
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
        Cmd cmd = new Cmd(args);
        cmd.parse();
        if (cmd.isPassed()) {
            Compiler compiler = new Compiler(cmd.getFileName());
            CompilationUnit compilationUnit = compiler.parse();

            if (cmd.isInspect()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValue(new File("ast.json"), compilationUnit);
            }

            GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable();
            SemanticErrorList semanticErrorList = new SemanticErrorList();
            PreAnalyse preAnalyse = new PreAnalyse(globalSymbolTable, semanticErrorList);
            preAnalyse.visitCompilationUnit(compilationUnit);

            if (semanticErrorList.size() != 0) {
                semanticErrorList.stream().forEach(logger::error);
            }

            System.out.println(globalSymbolTable.toString());
        }
    }
}
