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
	 * Visit a parse tree produced by {@link LoxParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDeclaration(LoxParser.PropertyDeclarationContext ctx);
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
	 * Visit a parse tree produced by {@link LoxParser#functionPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPart(LoxParser.FunctionPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(LoxParser.ModifierContext ctx);
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
	 * Visit a parse tree produced by {@link LoxParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(LoxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#elseBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBranch(LoxParser.ElseBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(LoxParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#initPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitPart(LoxParser.InitPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#conditionPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionPart(LoxParser.ConditionPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#updatePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatePart(LoxParser.UpdatePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(LoxParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LoxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(LoxParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(LoxParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LoxParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LoxParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Liter}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiter(LoxParser.LiterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LoxParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(LoxParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Member}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(LoxParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(LoxParser.UnaryContext ctx);
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