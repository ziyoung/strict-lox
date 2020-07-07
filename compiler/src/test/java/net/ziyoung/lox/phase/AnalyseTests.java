package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.ast.stmt.BlockStmt;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.compiler.Compiler;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
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
        AnalyseContext analyseContext = new AnalyseContext(globalSymbolTable, semanticErrorList);
        PreAnalyse preAnalyse = new PreAnalyse(analyseContext);
        preAnalyse.visitCompilationUnit(compilationUnit);

        Analyse analyse = new Analyse(analyseContext);
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
                Assertions.assertEquals(3, symbolTable1.getNextOffset());
                return null;
            }

            @Override
            public Void visitBlockStmt(BlockStmt node) {
                SymbolTable symbolTable1 = nodeSymbolTableMap.get(node);
                Assertions.assertNotNull(symbolTable1);
                Assertions.assertEquals(10, symbolTable1.getNextOffset());
                for (String name : names) {
                    Assertions.assertNotNull(symbolTable1.resolve(name));
                }
                return null;
            }
        };
        astBaseVisitor.visitCompilationUnit(compilationUnit);

        Symbol symbol = symbolTable.resolve("run");
        Assertions.assertNotNull(symbol);
        FunctionSymbol functionSymbol = (FunctionSymbol) symbol;
        Assertions.assertEquals(4, functionSymbol.getStackSize());
        Assertions.assertEquals(10, functionSymbol.getLocalSize());
    }
}
