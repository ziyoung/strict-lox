package net.ziyoung.lox.phase.visitor;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.LiteralType;
import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ExprTypeResolver extends AstBaseVisitor<Type> {

    private static final Logger logger = LoggerFactory.getLogger(ExprTypeResolver.class);

    private final SymbolTable symbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;
    private int stackSize = 0;

    public ExprTypeResolver(SymbolTable symbolTable, SemanticErrorList semanticErrorList, TypeChecker typeChecker) {
        this.symbolTable = symbolTable;
        this.semanticErrorList = semanticErrorList;
        this.typeChecker = typeChecker;
    }

    public int getStackSize() {
        return stackSize;
    }

    // Calculate expression stack size.
    public void updateStackSize(Type type) {
        updateStackSize(type, 1);
    }

    private void updateStackSize(Type type, int factor) {
        int size = TypeUtils.getTypeSize(type);
        stackSize = Math.max(stackSize, size * factor);
    }

    // Calculate call expression stack size.
    private void updateStackSize(List<Type> typeList, int base) {
        int size = typeList
                .stream()
                .map(TypeUtils::getTypeSize)
                .reduce(base, Integer::sum);
        stackSize = Math.max(stackSize, size);
    }

    @Override
    public Type visitAssignExpr(AssignExpr node) {
        Type lhsType = visitExpr(node.getLhs());
        Type rhsType = visitExpr(node.getRhs());
        Type promptType = typeChecker.validateAssign(node, lhsType, rhsType);
        node.setRhsPromotionType(promptType);
        return lhsType;
    }

    @Override
    public Type visitBinaryExpr(BinaryExpr node) {
        Type lhsType = visitExpr(node.getLhs());
        Type rhsType = visitExpr(node.getRhs());
        Identifier op = node.getOp();
        node.setLhsPromotionType(TypeUtils.getPromoteType(lhsType, rhsType));
        node.setRhsPromotionType(TypeUtils.getPromoteType(rhsType, lhsType));
        Type resultType = typeChecker.validateArithmetic(op, lhsType, rhsType);
        updateStackSize(resultType, 2);
        node.setEvalType(resultType);
        return resultType;
    }

    @Override
    public Type visitCallExpr(CallExpr node) {
        Type calleeType = visitExpr(node.getCallee());
        logger.info("call expr node {} {}", calleeType, node.getCallee());
        if (calleeType == null) {
            semanticErrorList.add(node.getPosition(), "Undefined function");
            return null;
        }

        if (!(calleeType instanceof FunctionType || calleeType instanceof OverloadFunctionType)) {
            semanticErrorList.add(node.getPosition(), "Can only call function or method");
            return null;
        }

        List<Expr> argumentList = node.getArgumentList();
        FunctionType functionType;
        if (calleeType instanceof OverloadFunctionType) {
            StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
            argumentList.forEach(expr -> {
                Type type = visitExpr(expr);
                stringJoiner.add(type == null ? "null" : type.getName());
            });
            functionType = ((OverloadFunctionType) calleeType).getFunctionType(stringJoiner.toString());
            if (functionType == null) {
                semanticErrorList.add(node.getPosition(), "Can't find corresponding function");
                return null;
            }
        } else {
            functionType = (FunctionType) calleeType;
        }

        List<FunctionType.Parameter> parameterList = functionType.getParameterList();
        if (parameterList.size() == argumentList.size()) {
            for (int i = 0; i < parameterList.size(); i++) {
                Type parameterType = parameterList.get(i).getType();
                Type argType = visitExpr(argumentList.get(i));
                if (parameterType != null && parameterType != argType) {
                    semanticErrorList.add(
                            argumentList.get(i).getPosition(),
                            String.format("Argument of type '%s' is not assignable to parameter of type '%s'", argumentList.get(i), parameterType)
                    );
                }
            }
        } else {
            semanticErrorList.add(node.getPosition(), "Unmatched parameter size");
        }

        List<Type> typeList = parameterList.stream()
                .map(FunctionType.Parameter::getType)
                .collect(Collectors.toList());
        int baseSize = functionType.getName().equals("print") ? 1 : 0;
        updateStackSize(typeList, baseSize);
        return functionType.getReturnType();
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
        updateStackSize(type, 1);
        return type;
    }

    @Override
    public Type visitMemberExpr(MemberExpr node) {
        return super.visitMemberExpr(node);
    }

    @Override
    public Type visitParameterExpr(ParameterExpr node) {
        return super.visitParameterExpr(node);
    }

    @Override
    public Type visitUnaryExpr(UnaryExpr node) {
        String op = node.getOp().getName();
        Type rhsType = visitExpr(node.getRhs());
        Type resultType = typeChecker.validateUnary(node, op, rhsType);
        updateStackSize(resultType, 1);
        return resultType;
    }

    @Override
    public Type visitVariableExpr(VariableExpr node) {
        Symbol symbol = symbolTable.resolve(node.getName());
        if (symbol == null) {
            semanticErrorList.add(node.getPosition(), String.format("Variable '%s' has not been defined", node.getName()));
            return null;
        }
        updateStackSize(symbol.getType(), 1);
        return symbol.getType();
    }
}
