package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.*;
import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.ast.stmt.*;
import net.ziyoung.lox.symbol.*;
import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeChecker;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class Analyse extends AstBaseVisitor<Void> {

    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;
    private final Map<Node, SymbolTable> nodeSymbolTableMap = new IdentityHashMap<>();
    private SymbolTable curSymbolTable;

    public Analyse(GlobalSymbolTable globalSymbolTable, SemanticErrorList semanticErrorList, TypeChecker typeChecker) {
        this.globalSymbolTable = globalSymbolTable;
        this.semanticErrorList = semanticErrorList;
        this.typeChecker = typeChecker;
    }

    @Override
    public Void visitTypeNode(TypeNode node) {
        return super.visitTypeNode(node);
    }

    @Override
    public Void visitIdentifier(Identifier node) {
        return super.visitIdentifier(node);
    }

    @Override
    public Void visitBinaryExpr(BinaryExpr node) {
        return super.visitBinaryExpr(node);
    }

    @Override
    public Void visitCallExpr(CallExpr node) {
        return super.visitCallExpr(node);
    }

    @Override
    public Void visitGroupExpr(GroupExpr node) {
        return super.visitGroupExpr(node);
    }

    @Override
    public Void visitLiteral(Literal node) {
        return super.visitLiteral(node);
    }

    @Override
    public Void visitParameter(Parameter node) {
        return super.visitParameter(node);
    }

    @Override
    public Void visitAssignExpr(AssignExpr node) {
        return super.visitAssignExpr(node);
    }

    @Override
    public Void visitMemberExpr(MemberExpr node) {
        return super.visitMemberExpr(node);
    }

    @Override
    public Void visitUnaryExpr(UnaryExpr node) {
        return super.visitUnaryExpr(node);
    }

    @Override
    public Void visitVariableExpr(VariableExpr node) {
        return super.visitVariableExpr(node);
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
        ExprVisitor exprVisitor = new ExprVisitor(curSymbolTable, semanticErrorList, typeChecker);
        exprVisitor.visitExpr(node.getExpr());
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
            curSymbolTable = new SymbolTable(prevSymbolTable);
            int offset = 0;
            FunctionType functionType = (FunctionType) functionSymbol.getType();
            List<String> nameList = functionType.getArgNameList();
            List<Type> typeList = functionType.getArgTypeList();
            for (int i = 0; i < nameList.size(); i++) {
                LocalSymbol localSymbol = new LocalSymbol(nameList.get(i), typeList.get(i), offset);
                offset += typeList.get(i).getSlotSize();
                curSymbolTable.define(localSymbol);
            }
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

        ExprVisitor exprVisitor = new ExprVisitor(curSymbolTable, semanticErrorList, typeChecker);
        Expr initializer = node.getInitializer();
        if (initializer != null) {
            rhsType = exprVisitor.visitExpr(node.getInitializer());
        }
        typeChecker.validateAssign(id, lhsType, rhsType);

        Symbol symbol = new Symbol(id.getName(), lhsType);
        curSymbolTable.define(symbol);
        return null;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        curSymbolTable = globalSymbolTable.getGlobal();
        node.getDeclList().forEach(this::visitDecl);
        return null;
    }
}
