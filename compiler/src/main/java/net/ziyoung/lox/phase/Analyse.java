package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.ast.stmt.*;

public class Analyse extends AstBaseVisitor<Void> {
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
        return super.visitExpressionStmt(node);
    }

    @Override
    public Void visitForStmt(ForStmt node) {
        return super.visitForStmt(node);
    }

    @Override
    public Void visitFunctionDecl(FunctionDecl node) {
        return super.visitFunctionDecl(node);
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
        return super.visitVariableDecl(node);
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        return super.visitCompilationUnit(node);
    }
}
