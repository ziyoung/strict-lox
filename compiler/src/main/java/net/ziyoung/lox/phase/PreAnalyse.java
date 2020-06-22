package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeChecker;

public class PreAnalyse extends AstBaseVisitor<Void> {
    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;

    public PreAnalyse(GlobalSymbolTable globalSymbolTable, SemanticErrorList semanticErrorList) {
        this.globalSymbolTable = globalSymbolTable;
        this.semanticErrorList = semanticErrorList;
        typeChecker = new TypeChecker(globalSymbolTable, semanticErrorList);
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
        Type returnType = typeNode != null ? typeChecker.check(typeNode) : null;
        FunctionType functionType = new FunctionType(name, returnType);
        node.getParameterList().forEach(parameter -> {
            Type type = typeChecker.check(parameter.getTypeNode());
            functionType.addArg(parameter.getId().getName(), type);
        });
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