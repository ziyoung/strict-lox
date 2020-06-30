package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.phase.context.AnalyseContext;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.TypeChecker;

import java.util.Map;

public class Generate extends AstBaseVisitor<Void> {

    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;
    private final Map<Node, SymbolTable> nodeSymbolTableMap;
    private SymbolTable curSymbolTable;

    public Generate(AnalyseContext analyseContext, Map<Node, SymbolTable> nodeSymbolTableMap) {
        this.globalSymbolTable = analyseContext.getGlobalSymbolTable();
        this.semanticErrorList = analyseContext.getSemanticErrorList();
        this.typeChecker = analyseContext.getTypeChecker();
        this.nodeSymbolTableMap = nodeSymbolTableMap;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        curSymbolTable = globalSymbolTable.getGlobal();
        node.getDeclList().forEach(this::visitDecl);
        return null;
    }
}
