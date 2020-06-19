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
	 * Enter a parse tree produced by {@link LoxParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(LoxParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(LoxParser.PackageNameContext ctx);
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
	 * Enter a parse tree produced by {@link LoxParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDeclaration(LoxParser.PropertyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDeclaration(LoxParser.PropertyDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link LoxParser#functionPart}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPart(LoxParser.FunctionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#functionPart}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPart(LoxParser.FunctionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(LoxParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(LoxParser.ModifierContext ctx);
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
	 * Enter a parse tree produced by {@link LoxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LoxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LoxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#elseBranch}.
	 * @param ctx the parse tree
	 */
	void enterElseBranch(LoxParser.ElseBranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#elseBranch}.
	 * @param ctx the parse tree
	 */
	void exitElseBranch(LoxParser.ElseBranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(LoxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(LoxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#initPart}.
	 * @param ctx the parse tree
	 */
	void enterInitPart(LoxParser.InitPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#initPart}.
	 * @param ctx the parse tree
	 */
	void exitInitPart(LoxParser.InitPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#conditionPart}.
	 * @param ctx the parse tree
	 */
	void enterConditionPart(LoxParser.ConditionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#conditionPart}.
	 * @param ctx the parse tree
	 */
	void exitConditionPart(LoxParser.ConditionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#updatePart}.
	 * @param ctx the parse tree
	 */
	void enterUpdatePart(LoxParser.UpdatePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#updatePart}.
	 * @param ctx the parse tree
	 */
	void exitUpdatePart(LoxParser.UpdatePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(LoxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(LoxParser.ReturnStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code Group}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroup(LoxParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroup(LoxParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCall(LoxParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCall(LoxParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LoxParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LoxParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Liter}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiter(LoxParser.LiterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Liter}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiter(LoxParser.LiterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinary(LoxParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinary(LoxParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Member}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMember(LoxParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Member}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMember(LoxParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary(LoxParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link LoxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary(LoxParser.UnaryContext ctx);
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