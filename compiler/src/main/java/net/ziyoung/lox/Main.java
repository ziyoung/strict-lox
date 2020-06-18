package net.ziyoung.lox;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.cmd.Cmd;
import net.ziyoung.lox.compiler.Compiler;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Cmd cmd = new Cmd(args);
        cmd.parse();
        if (cmd.isPassed()) {
            Compiler compiler = new Compiler(cmd.getFileName());
            CompilationUnit compilationUnit = compiler.parse();
            if (cmd.isInspect()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("ast.json"), compilationUnit);
            }
        }
    }
}
