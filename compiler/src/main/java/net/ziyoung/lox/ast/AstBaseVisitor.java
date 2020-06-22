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
    public R visitLiteral(Literal node) {
        return null;
    }

    @Override
    public R visitParameter(Parameter node) {
        return null;
    }

    @Override
    public R visitAssignExpr(AssignExpr node) {
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

    @Override
    public R visitDecl(Decl decl) {
        if (decl instanceof VariableDecl) {
            return visitVariableDecl((VariableDecl) decl);
        }
        if (decl instanceof FunctionDecl) {
            return visitFunctionDecl((FunctionDecl) decl);
        }
        if (decl instanceof PropertyDecl) {
            return visitPropertyDecl((PropertyDecl) decl);
        }
        if (decl instanceof MethodDecl) {
            return visitMethodDecl((MethodDecl) decl);
        }
        if (decl instanceof ClassDecl) {
            return visitClassDecl((ClassDecl) decl);
        }
        return null;
    }
}
