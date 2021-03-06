package net.ziyoung.lox.ast;

import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.ast.stmt.*;

public interface AstVisitor<R> {
    R visitTypeNode(TypeNode node);

    R visitIdentifier(Identifier node);

    R visitParameterExpr(ParameterExpr node);

    R visitBinaryExpr(BinaryExpr node);

    R visitAssignExpr(AssignExpr node);

    R visitCallExpr(CallExpr node);

    R visitGroupExpr(GroupExpr node);

    R visitLiteral(Literal node);

    R visitMemberExpr(MemberExpr node);

    R visitUnaryExpr(UnaryExpr node);

    R visitVariableExpr(VariableExpr node);

    R visitBlockStmt(BlockStmt node);

    R visitClassDecl(ClassDecl node);

    R visitExpressionStmt(ExpressionStmt node);

    R visitForStmt(ForStmt node);

    R visitFunctionDecl(FunctionDecl node);

    R visitIfStmt(IfStmt node);

    R visitMethodDecl(MethodDecl node);

    R visitPropertyDecl(PropertyDecl node);

    R visitReturnStmt(ReturnStmt node);

    R visitVariableDecl(VariableDecl node);

    R visitCompilationUnit(CompilationUnit node);

    R visitExpr(Expr expr);

    R visitDecl(Decl decl);

    R visitStmt(Stmt stmt);
}
