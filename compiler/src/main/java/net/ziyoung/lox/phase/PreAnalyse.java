package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.FunctionType;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.Type;

public class PreAnalyse extends AstBaseVisitor<Void> {
    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;

    public PreAnalyse(GlobalSymbolTable globalSymbolTable, SemanticErrorList semanticErrorList) {
        this.globalSymbolTable = globalSymbolTable;
        this.semanticErrorList = semanticErrorList;
    }

    public GlobalSymbolTable getGlobalSymbolTable() {
        return globalSymbolTable;
    }

    public SemanticErrorList getSemanticErrorList() {
        return semanticErrorList;
    }

    @Override
    public Void visitFunctionDecl(FunctionDecl node) {
        String name = node.getId().getName();
        TypeNode typeNode = node.getReturnTypeNode();
        Type returnType = null;
        if (typeNode != null) {
            returnType = globalSymbolTable.resolveType(typeNode);
            if (returnType == null) {
                semanticErrorList.add(typeNode.getPosition(), "unknown type " + typeNode.getName());
            }
        }
        FunctionType functionType = new FunctionType(name, returnType);
        FunctionSymbol functionSymbol = new FunctionSymbol(name, functionType);
        globalSymbolTable.defineSymbol(functionSymbol);
        return null;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        node.getDeclList().forEach(this::visitDecl);
        return null;
    }
}
