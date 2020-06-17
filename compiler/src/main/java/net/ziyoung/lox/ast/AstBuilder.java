package net.ziyoung.lox.ast;

import net.ziyoung.lox.antlr.LoxBaseVisitor;
import net.ziyoung.lox.antlr.LoxParser;
import net.ziyoung.lox.ast.stmt.ClassDecl;
import net.ziyoung.lox.ast.stmt.Decl;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.ast.stmt.VariableDecl;

import java.util.List;
import java.util.stream.Collectors;

public class AstBuilder extends LoxBaseVisitor<Node> {
    @Override
    public CompilationUnit visitCompilationUnit(LoxParser.CompilationUnitContext ctx) {
        String packageName = ctx.packageDeclaration().ID().getText();
        List<Decl> declList = ctx.topLevelObject()
                .stream().map(this::visitTopLevelObject)
                .collect(Collectors.toList());
        return new CompilationUnit(packageName, declList);
    }

    @Override
    public Decl visitTopLevelObject(LoxParser.TopLevelObjectContext ctx) {
//        return (Decl) visitChildren(ctx);
        if (ctx.classDeclaration() != null) {
            return visitClassDeclaration(ctx.classDeclaration());
        }
        if (ctx.functionDeclaration() != null) {
            return visitFunctionDeclaration(ctx.functionDeclaration());
        }
        if (ctx.variableDeclaration() != null) {
            return visitVariableDeclaration(ctx.variableDeclaration());
        }
        return null;
    }

    @Override
    public ClassDecl visitClassDeclaration(LoxParser.ClassDeclarationContext ctx) {
        return null;
    }

    @Override
    public Node visitMemberDeclaration(LoxParser.MemberDeclarationContext ctx) {
        return super.visitMemberDeclaration(ctx);
    }

    @Override
    public Node visitPropertyDeclaration(LoxParser.PropertyDeclarationContext ctx) {
        return super.visitPropertyDeclaration(ctx);
    }

    @Override
    public FunctionDecl visitFunctionDeclaration(LoxParser.FunctionDeclarationContext ctx) {
        return null;
    }

    @Override
    public Node visitMethodDeclaration(LoxParser.MethodDeclarationContext ctx) {
        return super.visitMethodDeclaration(ctx);
    }

    @Override
    public Node visitFunctionPart(LoxParser.FunctionPartContext ctx) {
        return super.visitFunctionPart(ctx);
    }

    @Override
    public Node visitModifier(LoxParser.ModifierContext ctx) {
        return super.visitModifier(ctx);
    }

    @Override
    public Node visitTypeParameters(LoxParser.TypeParametersContext ctx) {
        return super.visitTypeParameters(ctx);
    }

    @Override
    public Node visitTypeParameter(LoxParser.TypeParameterContext ctx) {
        return super.visitTypeParameter(ctx);
    }

    @Override
    public Node visitType(LoxParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Node visitBlockStatement(LoxParser.BlockStatementContext ctx) {
        return super.visitBlockStatement(ctx);
    }

    @Override
    public Node visitStatement(LoxParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public Node visitExpressionStatement(LoxParser.ExpressionStatementContext ctx) {
        return super.visitExpressionStatement(ctx);
    }

    @Override
    public Node visitIfStatement(LoxParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public Node visitElseBranch(LoxParser.ElseBranchContext ctx) {
        return super.visitElseBranch(ctx);
    }

    @Override
    public Node visitForStatement(LoxParser.ForStatementContext ctx) {
        return super.visitForStatement(ctx);
    }

    @Override
    public Node visitInitPart(LoxParser.InitPartContext ctx) {
        return super.visitInitPart(ctx);
    }

    @Override
    public Node visitConditionPart(LoxParser.ConditionPartContext ctx) {
        return super.visitConditionPart(ctx);
    }

    @Override
    public Node visitUpdatePart(LoxParser.UpdatePartContext ctx) {
        return super.visitUpdatePart(ctx);
    }

    @Override
    public Node visitReturnStatement(LoxParser.ReturnStatementContext ctx) {
        return super.visitReturnStatement(ctx);
    }

    @Override
    public VariableDecl visitVariableDeclaration(LoxParser.VariableDeclarationContext ctx) {
        return null;
    }

    @Override
    public Node visitGroup(LoxParser.GroupContext ctx) {
        return super.visitGroup(ctx);
    }

    @Override
    public Node visitCall(LoxParser.CallContext ctx) {
        return super.visitCall(ctx);
    }

    @Override
    public Node visitIdent(LoxParser.IdentContext ctx) {
        return super.visitIdent(ctx);
    }

    @Override
    public Node visitLiter(LoxParser.LiterContext ctx) {
        return super.visitLiter(ctx);
    }

    @Override
    public Node visitAssign(LoxParser.AssignContext ctx) {
        return super.visitAssign(ctx);
    }

    @Override
    public Node visitBinary(LoxParser.BinaryContext ctx) {
        return super.visitBinary(ctx);
    }

    @Override
    public Node visitMember(LoxParser.MemberContext ctx) {
        return super.visitMember(ctx);
    }

    @Override
    public Node visitUnary(LoxParser.UnaryContext ctx) {
        return super.visitUnary(ctx);
    }

    @Override
    public Node visitExpressionList(LoxParser.ExpressionListContext ctx) {
        return super.visitExpressionList(ctx);
    }

    @Override
    public Node visitLiteral(LoxParser.LiteralContext ctx) {
        return super.visitLiteral(ctx);
    }
}
