// Generated from Lox.g4 by ANTLR 4.8
package net.ziyoung.lox.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LoxParser}.
 */
public interface LoxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LoxParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(LoxParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(LoxParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(LoxParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(LoxParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#topLevelObject}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelObject(LoxParser.TopLevelObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#topLevelObject}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelObject(LoxParser.TopLevelObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(LoxParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(LoxParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(LoxParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(LoxParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#proptertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProptertyDeclaration(LoxParser.ProptertyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#proptertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProptertyDeclaration(LoxParser.ProptertyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(LoxParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(LoxParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(LoxParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(LoxParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(LoxParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(LoxParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LoxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LoxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(LoxParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(LoxParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(LoxParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(LoxParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(LoxParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(LoxParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LoxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LoxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(LoxParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(LoxParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LoxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LoxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(LoxParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(LoxParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LoxParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LoxParser.LiteralContext ctx);
}