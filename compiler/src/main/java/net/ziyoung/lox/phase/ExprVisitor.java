package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.LiteralType;
import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.PrimitiveType;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeChecker;

public class ExprVisitor extends AstBaseVisitor<Type> {

    private final SymbolTable symbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;

    public ExprVisitor(SymbolTable symbolTable, SemanticErrorList semanticErrorList, TypeChecker typeChecker) {
        this.symbolTable = symbolTable;
        this.semanticErrorList = semanticErrorList;
        this.typeChecker = typeChecker;
    }

    @Override
    public Type visitAssignExpr(AssignExpr node) {
        Type lhsType = visitExpr(node.getLhs());
        Type rhsType = visitExpr(node.getRhs());
        typeChecker.validateAssign(node.getLhs(), lhsType, rhsType);
        return lhsType;
    }

    @Override
    public Type visitBinaryExpr(BinaryExpr node) {
        return super.visitBinaryExpr(node);
    }

    @Override
    public Type visitCallExpr(CallExpr node) {
        return super.visitCallExpr(node);
    }

    @Override
    public Type visitGroupExpr(GroupExpr node) {
        return super.visitGroupExpr(node);
    }

    @Override
    public Type visitLiteral(Literal node) {
        Type type;
        LiteralType literalType = node.getLiteralType();
        switch (literalType) {
            case BOOL:
                type = PrimitiveType.BOOL;
                break;
            case INT:
                try {
                    Integer.parseInt(node.getValue());
                    type = PrimitiveType.INT;
                } catch (NumberFormatException exception) {
                    type = PrimitiveType.LONG;
                }
                break;
            case DOUBLE:
                try {
                    Float.parseFloat(node.getValue());
                    type = PrimitiveType.FLOAT;
                } catch (NumberFormatException exception) {
                    type = PrimitiveType.DOUBLE;
                }
                break;
            case STRING:
                type = PrimitiveType.STRING;
                break;
            default:
                throw new RuntimeException("Unsupported type " + literalType);
        }
        node.setEvalType(type);
        return type;
    }

    @Override
    public Type visitMemberExpr(MemberExpr node) {
        return super.visitMemberExpr(node);
    }

    @Override
    public Type visitParameter(Parameter node) {
        return super.visitParameter(node);
    }

    @Override
    public Type visitUnaryExpr(UnaryExpr node) {
        return super.visitUnaryExpr(node);
    }

    @Override
    public Type visitVariableExpr(VariableExpr node) {
        Symbol symbol = symbolTable.resolve(node.getName());
        if (symbol == null) {
            semanticErrorList.add(node.getPosition(), String.format("Variable '%s' has not been defined", node.getName()));
            return null;
        }
        return symbol.getType();
    }
}