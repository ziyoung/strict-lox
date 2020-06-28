package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.phase.context.AnalyseContext;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeChecker;

public class PreAnalyse extends AstBaseVisitor<Void> {
    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;

    public PreAnalyse(AnalyseContext analyseContext) {
        this.globalSymbolTable = analyseContext.getGlobalSymbolTable();
        this.semanticErrorList = analyseContext.getSemanticErrorList();
        this.typeChecker = analyseContext.getTypeChecker();
    }

    @Override
    public Void visitFunctionDecl(FunctionDecl node) {
        String name = node.getId().getName();
        TypeNode typeNode = node.getReturnTypeNode();
        Type returnType = typeChecker.check(typeNode);
        FunctionType functionType = new FunctionType(name, returnType);
        node.getParameterExprList().forEach(parameter -> {
            Type type = typeChecker.check(parameter.getTypeNode());
            Identifier id = parameter.getId();
            if (functionType.containsArgName(id.getName())) {
                semanticErrorList.add(id.getPosition(), String.format("Duplicated parameter '%s'", id.getName()));
                return;
            }
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
