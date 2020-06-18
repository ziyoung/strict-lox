package net.ziyoung.lox.compiler;

import net.ziyoung.lox.antlr.LoxLexer;
import net.ziyoung.lox.antlr.LoxParser;
import net.ziyoung.lox.fe.AstBuilder;
import net.ziyoung.lox.ast.CompilationUnit;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Compiler {
    private final String fileName;
//    private LoxParser parser;
//    private CompilationUnit compilationUnit;

    public Compiler(String fileName) {
        this.fileName = fileName;
    }

    public CompilationUnit parse() throws IOException {
        CharStream charStream = CharStreams.fromFileName(fileName);
        LoxLexer lexer = new LoxLexer(charStream);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        LoxParser parser = new LoxParser(stream);
        ParseTree tree = parser.compilationUnit();
        return (CompilationUnit) tree.accept(new AstBuilder());
    }
}
