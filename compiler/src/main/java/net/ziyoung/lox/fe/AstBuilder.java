package net.ziyoung.lox.fe;

import net.ziyoung.lox.antlr.LoxBaseVisitor;
import net.ziyoung.lox.antlr.LoxParser;
import net.ziyoung.lox.ast.*;
import net.ziyoung.lox.ast.expr.Literal;
import net.ziyoung.lox.ast.expr.Parameter;
import net.ziyoung.lox.ast.expr.VariableExpr;
import net.ziyoung.lox.ast.stmt.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Collections;
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
        return visitFunctionPart(ctx.functionPart());
    }

    @Override
    public Node visitMethodDeclaration(LoxParser.MethodDeclarationContext ctx) {
        return super.visitMethodDeclaration(ctx);
    }

    @Override
    public FunctionDecl visitFunctionPart(LoxParser.FunctionPartContext ctx) {
        Identifier identifier = Identifier.from(ctx.ID());
        List<Parameter> parameterList = Collections.emptyList();
        TypeNode typeNode = TypeNode.from(ctx.type());
        if (ctx.typeParameters() != null) {
            parameterList = new ArrayList<>();
            for (LoxParser.TypeParameterContext parameterContext : ctx.typeParameters().typeParameter()) {
                parameterList.add(visitTypeParameter(parameterContext));
            }
        }
        BlockStmt blockStmt = visitBlockStatement(ctx.blockStatement());
        return new FunctionDecl(identifier, parameterList, typeNode, blockStmt);
    }

    @Override
    public Node visitModifier(LoxParser.ModifierContext ctx) {
        return super.visitModifier(ctx);
    }

    @Override
    public Parameter visitTypeParameter(LoxParser.TypeParameterContext ctx) {
        Identifier identifier = Identifier.from(ctx.ID());
        TypeNode typeNode = TypeNode.from(ctx.type());
        return new Parameter(identifier, typeNode);
    }

    @Override
    public BlockStmt visitBlockStatement(LoxParser.BlockStatementContext ctx) {
        List<Stmt> stmtList = Collections.emptyList();
        if (ctx.statement().size() != 0) {
            stmtList = new ArrayList<>();
            for (LoxParser.StatementContext statementContext : ctx.statement()) {
                Stmt stmt = (Stmt) visitStatement(statementContext);
                stmtList.add(stmt);
            }
        }
        return new BlockStmt(stmtList);
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
        Identifier identifier = Identifier.from(ctx.ID());
        TypeNode typeNode = TypeNode.from(ctx.type());
        Expr init = null;
        LoxParser.ExpressionContext expressionContext = ctx.expression();
        if (expressionContext != null) {
            init = (Expr) visit(expressionContext);
        }
        VariableDecl variableDecl = new VariableDecl(identifier, typeNode, init);
        variableDecl.setPosition(ctx);
        return variableDecl;
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
    public Node visitVariable(LoxParser.VariableContext ctx) {
        Identifier identifier = Identifier.from(ctx.ID());
        return new VariableExpr(identifier);
    }

    @Override
    public Node visitLiter(LoxParser.LiterContext ctx) {
        LoxParser.LiteralContext literalContext = ctx.literal();
        LiteralType kind;
        TerminalNode terminalNode;
        if (literalContext.BOOL_LITERAL() != null) {
            terminalNode = literalContext.BOOL_LITERAL();
            kind = LiteralType.BOOL;
        } else if (literalContext.INT_LITERAL() != null) {
            terminalNode = literalContext.INT_LITERAL();
            kind = LiteralType.INT;
        } else if (literalContext.DOUBLE_LITERAL() != null) {
            terminalNode = literalContext.DOUBLE_LITERAL();
            kind = LiteralType.DOUBLE;
        } else if (literalContext.STRING_LITERAL() != null) {
            terminalNode = literalContext.STRING_LITERAL();
            kind = LiteralType.STRING;
        } else if (literalContext.NULL_LITERAL() != null) {
            terminalNode = literalContext.NULL_LITERAL();
            kind = LiteralType.NULL;
        } else {
            throw new RuntimeException("unreachable condition");
        }

        return Literal.from(terminalNode, kind);
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
}
