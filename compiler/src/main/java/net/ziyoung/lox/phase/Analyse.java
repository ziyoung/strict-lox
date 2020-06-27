package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.*;
import net.ziyoung.lox.ast.expr.AssignExpr;
import net.ziyoung.lox.ast.expr.CallExpr;
import net.ziyoung.lox.ast.stmt.*;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class Analyse extends AstBaseVisitor<Void> {

    private static final Logger logger = LoggerFactory.getLogger(Analyse.class);

    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;
    private final Map<Node, SymbolTable> nodeSymbolTableMap = new IdentityHashMap<>();
    private SymbolTable curSymbolTable;
    private ExprVisitor curExprVisitor;

    public Analyse(GlobalSymbolTable globalSymbolTable, SemanticErrorList semanticErrorList, TypeChecker typeChecker) {
        this.globalSymbolTable = globalSymbolTable;
        this.semanticErrorList = semanticErrorList;
        this.typeChecker = typeChecker;
    }

    public Map<Node, SymbolTable> getNodeSymbolTableMap() {
        return nodeSymbolTableMap;
    }

    @Override
    public Void visitCallExpr(CallExpr node) {
        Type calleeType = curExprVisitor.visitExpr(node.getCallee());
        if (calleeType == null) {
            semanticErrorList.add(node.getPosition(), "Undefined function");
        } else if (calleeType instanceof FunctionType) {
            FunctionType functionType = (FunctionType) calleeType;
            List<FunctionType.Parameter> parameterList = functionType.getParameterList();
            List<Expr> argumentList = node.getArgumentList();

            if (parameterList.size() == argumentList.size()) {
                for (int i = 0; i < parameterList.size(); i++) {
                    Type parameterType = parameterList.get(i).getType();
                    Type argType = curExprVisitor.visitExpr(argumentList.get(i));
                    if (parameterType != null && parameterType != argType) {
                        semanticErrorList.add(argumentList.get(i).getPosition(), String.format("Argument of type 'xxx' is not assignable to parameter of type '%s'", parameterType));
                    }
                }
            } else {
                semanticErrorList.add(node.getPosition(), "Unmatched parameter size");
            }
        } else {
            semanticErrorList.add(node.getPosition(), "Can only call function or method");
        }
        return null;
    }

    @Override
    public Void visitAssignExpr(AssignExpr node) {
        return super.visitAssignExpr(node);
    }

    @Override
    public Void visitBlockStmt(BlockStmt node) {
        return super.visitBlockStmt(node);
    }

    @Override
    public Void visitClassDecl(ClassDecl node) {
        return super.visitClassDecl(node);
    }

    @Override
    public Void visitExpressionStmt(ExpressionStmt node) {
        if (node.getExpr().usedAsStmt()) {
            ExprVisitor exprVisitor = new ExprVisitor(curSymbolTable, semanticErrorList, typeChecker);
            exprVisitor.visitExpr(node.getExpr());
        } else {
            semanticErrorList.add(node.getPosition(), "Expression can't be used as statement");
        }
        return null;
    }

    @Override
    public Void visitForStmt(ForStmt node) {
        return super.visitForStmt(node);
    }

    @Override
    public Void visitFunctionDecl(FunctionDecl node) {
        String name = node.getId().getName();
        FunctionSymbol functionSymbol = (FunctionSymbol) curSymbolTable.resolve(name);
        if (functionSymbol == null) {
            throw new RuntimeException("FunctionSymbol is required");
        }

        SymbolTable prevSymbolTable = curSymbolTable;
        try {
            curSymbolTable = new SymbolTable(prevSymbolTable, 0);
            nodeSymbolTableMap.put(node, curSymbolTable);
            curExprVisitor = new ExprVisitor(curSymbolTable, semanticErrorList, typeChecker);

            FunctionType functionType = (FunctionType) functionSymbol.getType();
            functionType.getParameterList().forEach(parameter -> {
                Symbol symbol = new Symbol(parameter.getName(), parameter.getType());
                curSymbolTable.define(symbol);
            });
            // FIXME: use visitBlockStmt.
            node.getBody().getStmtList().forEach(this::visitStmt);
        } finally {
            curSymbolTable = prevSymbolTable;
        }
        return null;
    }

    @Override
    public Void visitIfStmt(IfStmt node) {
        return super.visitIfStmt(node);
    }

    @Override
    public Void visitMethodDecl(MethodDecl node) {
        return super.visitMethodDecl(node);
    }

    @Override
    public Void visitPropertyDecl(PropertyDecl node) {
        return super.visitPropertyDecl(node);
    }

    @Override
    public Void visitReturnStmt(ReturnStmt node) {
        return super.visitReturnStmt(node);
    }

    @Override
    public Void visitVariableDecl(VariableDecl node) {
        Identifier id = node.getId();
        if (curSymbolTable.resolve(id.getName()) != null) {
            semanticErrorList.add(id.getPosition(), id.getName() + " has been declared");
        }

        Type lhsType = typeChecker.check(node.getTypeNode());
        Type rhsType = null;

        Expr initializer = node.getInitializer();
        if (initializer != null) {
            rhsType = curExprVisitor.visitExpr(node.getInitializer());
        }
        typeChecker.validateAssign(id, lhsType, rhsType);

        Symbol symbol = new Symbol(id.getName(), lhsType);
        curSymbolTable.define(symbol);
        logger.info("symbol is {}", symbol.getName());
        return null;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        curSymbolTable = globalSymbolTable.getGlobal();
        curExprVisitor = new ExprVisitor(curSymbolTable, semanticErrorList, typeChecker);
        node.getDeclList().forEach(this::visitDecl);
        return null;
    }
}
