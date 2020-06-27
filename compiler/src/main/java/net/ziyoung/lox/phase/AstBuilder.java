package net.ziyoung.lox.phase;

import net.ziyoung.lox.antlr.LoxBaseVisitor;
import net.ziyoung.lox.antlr.LoxParser;
import net.ziyoung.lox.ast.*;
import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.ast.stmt.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AstBuilder extends LoxBaseVisitor<Node> {
    @Override
    public CompilationUnit visitCompilationUnit(LoxParser.CompilationUnitContext ctx) {
        String packageName = ctx.packageDeclaration().packageName().getText();
        List<Decl> declList = ctx.topLevelObject()
                .stream()
                .map(this::visitTopLevelObject)
                .collect(Collectors.toList());
        return new CompilationUnit(packageName, declList);
    }

    @Override
    public Decl visitTopLevelObject(LoxParser.TopLevelObjectContext ctx) {
        if (ctx.classDeclaration() != null) {
            return visitClassDeclaration(ctx.classDeclaration());
        }
        if (ctx.functionDeclaration() != null) {
            return visitFunctionDeclaration(ctx.functionDeclaration());
        }
        if (ctx.variableDeclaration() != null) {
            return visitVariableDeclaration(ctx.variableDeclaration());
        }
        throw new RuntimeException(String.format("unknown TopLevelObject %s", ctx));
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
        Identifier identifier = Identifier.of(ctx.ID());
        List<ParameterExpr> parameterExprList = Collections.emptyList();
        TypeNode typeNode = TypeNode.of(ctx.type());
        if (ctx.typeParameters() != null) {
            parameterExprList = ctx.typeParameters().typeParameter()
                    .stream()
                    .map(this::visitTypeParameter)
                    .collect(Collectors.toList());
        }
        BlockStmt blockStmt = visitBlockStatement(ctx.blockStatement());
        return new FunctionDecl(identifier, parameterExprList, typeNode, blockStmt);
    }

    @Override
    public Node visitModifier(LoxParser.ModifierContext ctx) {
        return super.visitModifier(ctx);
    }

    @Override
    public ParameterExpr visitTypeParameter(LoxParser.TypeParameterContext ctx) {
        Identifier identifier = Identifier.of(ctx.ID());
        TypeNode typeNode = TypeNode.of(ctx.type());
        return new ParameterExpr(identifier, typeNode);
    }

    @Override
    public BlockStmt visitBlockStatement(LoxParser.BlockStatementContext ctx) {
        List<Stmt> stmtList = Collections.emptyList();
        if (ctx.statement().size() != 0) {
            stmtList = ctx.statement()
                    .stream()
                    .map(statementContext -> (Stmt) visitStatement(statementContext))
                    .collect(Collectors.toList());
        }
        return new BlockStmt(stmtList);
    }

    @Override
    public Stmt visitExpressionStatement(LoxParser.ExpressionStatementContext ctx) {
        Expr expr = (Expr) visit(ctx.expression());
        return new ExpressionStmt(expr);
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
        Identifier identifier = Identifier.of(ctx.ID());
        TypeNode typeNode = TypeNode.of(ctx.type());
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
        GroupExpr groupExpr = new GroupExpr((Expr) visit(ctx.expression()));
        groupExpr.setPosition(ctx);
        return groupExpr;
    }

    @Override
    public Node visitCall(LoxParser.CallContext ctx) {
        Expr callee = (Expr) visit(ctx.expression());
        List<Expr> argumentList = Collections.emptyList();
        if (ctx.expressionList().size() != 0) {
            argumentList = ctx.expressionList(0)
                    .expression()
                    .stream()
                    .map(expressionContext -> (Expr) visit(expressionContext))
                    .collect(Collectors.toList());
        }
        CallExpr callExpr = new CallExpr(callee, argumentList);
        callExpr.setPosition(ctx);
        return callExpr;
    }

    @Override
    public Node visitVariable(LoxParser.VariableContext ctx) {
        VariableExpr variableExpr = new VariableExpr(Identifier.of(ctx.ID()));
        variableExpr.setPosition(ctx);
        return variableExpr;
    }

    @Override
    public Node visitLiter(LoxParser.LiterContext ctx) {
        LoxParser.LiteralContext literalContext = ctx.literal();
        LiteralType type;
        TerminalNode terminalNode;
        if (literalContext.BOOL_LITERAL() != null) {
            terminalNode = literalContext.BOOL_LITERAL();
            type = LiteralType.BOOL;
        } else if (literalContext.INT_LITERAL() != null) {
            terminalNode = literalContext.INT_LITERAL();
            type = LiteralType.INT;
        } else if (literalContext.DOUBLE_LITERAL() != null) {
            terminalNode = literalContext.DOUBLE_LITERAL();
            type = LiteralType.DOUBLE;
        } else if (literalContext.STRING_LITERAL() != null) {
            terminalNode = literalContext.STRING_LITERAL();
            type = LiteralType.STRING;
        } else if (literalContext.NULL_LITERAL() != null) {
            terminalNode = literalContext.NULL_LITERAL();
            type = LiteralType.NULL;
        } else {
            throw new RuntimeException("unreachable condition");
        }

        return Literal.of(terminalNode, type);
    }

    @Override
    public BinaryExpr visitBinary(LoxParser.BinaryContext ctx) {
        Expr lhs = (Expr) visit(ctx.expression(0));
        Expr rhs = (Expr) visit(ctx.expression(1));
        Identifier op = Identifier.of(ctx.op);
        BinaryExpr binaryExpr = ctx.op.getType() == LoxParser.Assign
                ? new AssignExpr(lhs, op, rhs)
                : new BinaryExpr(lhs, op, rhs);
        binaryExpr.setPosition(ctx);
        return binaryExpr;
    }

    @Override
    public Node visitMember(LoxParser.MemberContext ctx) {
        return super.visitMember(ctx);
    }

    @Override
    public Node visitUnary(LoxParser.UnaryContext ctx) {
        return super.visitUnary(ctx);
    }
}
