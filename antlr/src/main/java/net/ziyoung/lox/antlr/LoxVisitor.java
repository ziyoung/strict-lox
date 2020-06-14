// Generated from Lox.g4 by ANTLR 4.8
package net.ziyoung.lox.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LoxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LoxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LoxParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(LoxParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(LoxParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#topLevelObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelObject(LoxParser.TopLevelObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(LoxParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(LoxParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#proptertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProptertyDeclaration(LoxParser.ProptertyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(LoxParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(LoxParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(LoxParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LoxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(LoxParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(LoxParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(LoxParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LoxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(LoxParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LoxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(LoxParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LoxParser.LiteralContext ctx);
}