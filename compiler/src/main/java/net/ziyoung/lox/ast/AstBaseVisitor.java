package net.ziyoung.lox.ast;

import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.ast.stmt.*;

public abstract class AstBaseVisitor<R> implements AstVisitor<R> {
    @Override
    public R visitTypeNode(TypeNode node) {
        return null;
    }

    @Override
    public R visitIdentifier(Identifier node) {
        return null;
    }

    @Override
    public R visitBinaryExpr(BinaryExpr node) {
        return null;
    }

    @Override
    public R visitCallExpr(CallExpr node) {
        return null;
    }

    @Override
    public R visitGroupExpr(GroupExpr node) {
        return null;
    }

    @Override
    public R visitLiteralExpr(LiteralExpr node) {
        return null;
    }

    @Override
    public R visitMemberExpr(MemberExpr node) {
        return null;
    }

    @Override
    public R visitUnaryExpr(UnaryExpr node) {
        return null;
    }

    @Override
    public R visitVariableExpr(VariableExpr node) {
        return null;
    }

    @Override
    public R visitBlockStmt(BlockStmt node) {
        return null;
    }

    @Override
    public R visitClassDecl(ClassDecl node) {
        return null;
    }

    @Override
    public R visitExpressionStmt(ExpressionStmt node) {
        return null;
    }

    @Override
    public R visitForStmt(ForStmt node) {
        return null;
    }

    @Override
    public R visitFunctionDecl(FunctionDecl node) {
        return null;
    }

    @Override
    public R visitIfStmt(IfStmt node) {
        return null;
    }

    @Override
    public R visitMethodDecl(MethodDecl node) {
        return null;
    }

    @Override
    public R visitPropertyDecl(PropertyDecl node) {
        return null;
    }

    @Override
    public R visitReturnStmt(ReturnStmt node) {
        return null;
    }

    @Override
    public R visitVariableDecl(VariableDecl node) {
        return null;
    }

    @Override
    public R visitCompilationUnit(CompilationUnit node) {
        return null;
    }
}
