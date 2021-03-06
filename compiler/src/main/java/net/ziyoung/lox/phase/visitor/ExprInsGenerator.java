package net.ziyoung.lox.phase.visitor;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.expr.*;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.*;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;

public class ExprInsGenerator extends AstBaseVisitor<Type> {

    private static final Logger logger = LoggerFactory.getLogger(ExprInsGenerator.class);

    private final SymbolTable curSymbolTable;
    private final MethodVisitor curMethodVisitor;
    private final String ownerClass;

    public ExprInsGenerator(SymbolTable curSymbolTable, MethodVisitor curMethodVisitor, String ownerClass) {
        this.curSymbolTable = curSymbolTable;
        this.curMethodVisitor = curMethodVisitor;
        this.ownerClass = ownerClass;
    }

    public void genDefaultInitializer(Type type) {
        if (type == PrimitiveType.BOOL || type == PrimitiveType.INT) {
            curMethodVisitor.visitInsn(Opcodes.ICONST_0);
        } else if (type == PrimitiveType.LONG) {
            curMethodVisitor.visitInsn(Opcodes.LCONST_0);
        } else if (type == PrimitiveType.FLOAT) {
            curMethodVisitor.visitInsn(Opcodes.FCONST_0);
        } else if (type == PrimitiveType.DOUBLE) {
            curMethodVisitor.visitInsn(Opcodes.DCONST_0);
        } else if (type == PrimitiveType.STRING) {
            curMethodVisitor.visitLdcInsn("");
        } else {
            throw new RuntimeException(String.format("Unsupported type %s", type));
        }
    }

    public void genTypePrompt(Type type, Type promptType) {
        if (promptType != null) {
            curMethodVisitor.visitInsn(TypeUtils.getCastCode(type, promptType));
        }
    }

    @Override
    public Type visitAssignExpr(AssignExpr node) {
        return super.visitAssignExpr(node);
    }

    @Override
    public Type visitBinaryExpr(BinaryExpr node) {
        Type lhsType = visitExpr(node.getLhs());
        Type lhsPromotionType = node.getLhsPromotionType();
        genTypePrompt(lhsType, lhsPromotionType);

        Type rhsType = visitExpr(node.getRhs());
        Type rhsPromotionType = node.getRhsPromotionType();
        genTypePrompt(rhsType, rhsPromotionType);

        Type evalType = node.getEvalType();
        int code = TypeUtils.getArithmeticCode(evalType, node.getOp().getName());
        curMethodVisitor.visitInsn(code);
        return node.getEvalType();
    }

    @Override
    public Type visitUnaryExpr(UnaryExpr node) {
        return super.visitUnaryExpr(node);
    }

    @Override
    public Type visitCallExpr(CallExpr node) {
        Type type = visitExpr(node.getCallee());
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
        node.getArgumentList()
                .forEach(expr -> {
                    Type type1 = visitExpr(expr);
                    stringJoiner.add(type1.getName());
                });
        FunctionType functionType;
        if (type instanceof OverloadFunctionType) {
            OverloadFunctionType overloadFunctionType = (OverloadFunctionType) type;
            functionType = overloadFunctionType.getFunctionType(stringJoiner.toString());
        } else {
            functionType = (FunctionType) type;
        }
        // FIXME: there's only static method now.
        String functionName = functionType.getName();
        FunctionSymbol functionSymbol = (FunctionSymbol) curSymbolTable.resolve(functionName);
        // FIXME: use a better way.
        if (functionName.equals("print")) {
            curMethodVisitor.visitMethodInsn(
                    Opcodes.INVOKEVIRTUAL,
                    functionSymbol.getOwnerClass(),
                    "println",
                    functionType.getDescriptor(),
                    false
            );
        } else {
            curMethodVisitor.visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    ownerClass,
                    functionName,
                    functionType.getDescriptor(),
                    false
            );
        }
        return null;
    }

    @Override
    public Type visitLiteral(Literal node) {
        Type type = node.getEvalType();
        if (type == PrimitiveType.BOOL) {
            int val = node.getValue().equals("true") ? 1 : 0;
            curMethodVisitor.visitIntInsn(Opcodes.BIPUSH, val);
        } else if (type == PrimitiveType.INT) {
            int val = Integer.parseInt(node.getValue());
            curMethodVisitor.visitLdcInsn(val);
        } else if (type == PrimitiveType.LONG) {
            long val = Long.parseLong(node.getValue());
            curMethodVisitor.visitLdcInsn(val);
        } else if (type == PrimitiveType.FLOAT) {
            float val = Float.parseFloat(node.getValue());
            curMethodVisitor.visitLdcInsn(val);
        } else if (type == PrimitiveType.DOUBLE) {
            double val = Double.parseDouble(node.getValue());
            curMethodVisitor.visitLdcInsn(val);
        } else if (type == PrimitiveType.STRING) {
            curMethodVisitor.visitLdcInsn(node.getValue());
        } else {
            throw new RuntimeException(String.format("Unknown type %s", type));
        }
        return type;
    }

    @Override
    public Type visitVariableExpr(VariableExpr node) {
        Symbol symbol = curSymbolTable.resolve(node.getName());
        if (symbol.isFunction()) {
            FunctionSymbol functionSymbol = (FunctionSymbol) symbol;
            logger.info("get callee {}", functionSymbol.getName());
            // FIXME: use a better way.
            if (functionSymbol.getName().equals("print")) {
                String descriptor = "L" + functionSymbol.getOwnerClass() + ";";
                curMethodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", descriptor);
            }
        } else {
            if (symbol.isStaticField()) {
                curMethodVisitor.visitFieldInsn(Opcodes.GETSTATIC, ownerClass, symbol.getName(), symbol.getDescriptor());
            } else {
                int op = TypeUtils.getVarLoadCode(symbol.getType());
                curMethodVisitor.visitVarInsn(op, symbol.getOffset());
            }
        }
        return symbol.getType();
    }
}
