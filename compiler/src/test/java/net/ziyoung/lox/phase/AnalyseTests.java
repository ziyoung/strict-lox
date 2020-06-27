package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.compiler.Compiler;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.TypeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AnalyseTests {

    @Test
    @DisplayName("inspect function symbol table")
    void inspectSymbolTable() {
        Compiler compiler = new Compiler("src/test/resources/analyse.lox");
        CompilationUnit compilationUnit = Assertions.assertDoesNotThrow(compiler::parse);

        GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable();
        SemanticErrorList semanticErrorList = new SemanticErrorList();
        PreAnalyse preAnalyse = new PreAnalyse(globalSymbolTable, semanticErrorList);
        preAnalyse.visitCompilationUnit(compilationUnit);

        TypeChecker typeChecker = new TypeChecker(globalSymbolTable, semanticErrorList);
        Analyse analyse = new Analyse(globalSymbolTable, semanticErrorList, typeChecker);
        analyse.visitCompilationUnit(compilationUnit);

        String[] names = new String[]{"i", "l", "f", "d", "s"};

        SymbolTable symbolTable = globalSymbolTable.getGlobal();
        for (String name : names) {
            Assertions.assertNotNull(symbolTable.resolve(name));
        }

        Map<Node, SymbolTable> nodeSymbolTableMap = analyse.getNodeSymbolTableMap();
        AstBaseVisitor<Void> astBaseVisitor = new AstBaseVisitor<>() {

            @Override
            public Void visitCompilationUnit(CompilationUnit node) {
                node.getDeclList().forEach(decl -> {
                    if (decl instanceof FunctionDecl) {
                        visitFunctionDecl((FunctionDecl) decl);
                    }
                });
                return null;
            }

            @Override
            public Void visitFunctionDecl(FunctionDecl node) {
                SymbolTable symbolTable1 = nodeSymbolTableMap.get(node);
                Assertions.assertNotNull(symbolTable1);
                Assertions.assertEquals(7, symbolTable1.getNextOffset());
                for (String name : names) {
                    Assertions.assertNotNull(symbolTable1.resolve(name));
                }
                return null;
            }
        };
        astBaseVisitor.visitCompilationUnit(compilationUnit);
    }
}
