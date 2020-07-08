package net.ziyoung.lox.phase.visitor;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.expr.BinaryExpr;
import net.ziyoung.lox.ast.expr.CallExpr;
import net.ziyoung.lox.ast.expr.UnaryExpr;
import net.ziyoung.lox.ast.expr.VariableExpr;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.PrimitiveType;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeUtils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ExprInsGenerator extends AstBaseVisitor<Void> {

    private final SymbolTable curSymbolTable;
    private final MethodVisitor curMethodVisitor;
    private final String ownerClass;

    public ExprInsGenerator(SymbolTable curSymbolTable, MethodVisitor curMethodVisitor, String ownerClass) {
        this.curSymbolTable = curSymbolTable;
        this.curMethodVisitor = curMethodVisitor;
        this.ownerClass = ownerClass;
    }

    public void visitDefaultInitializer(Type type) {
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

    @Override
    public Void visitBinaryExpr(BinaryExpr node) {
        return super.visitBinaryExpr(node);
    }

    @Override
    public Void visitUnaryExpr(UnaryExpr node) {
        return super.visitUnaryExpr(node);
    }

    @Override
    public Void visitCallExpr(CallExpr node) {
        return super.visitCallExpr(node);
    }

    @Override
    public Void visitVariableExpr(VariableExpr node) {
        Symbol symbol = curSymbolTable.resolve(node.getName());
        if (symbol.isStaticField()) {
            curMethodVisitor.visitFieldInsn(Opcodes.GETSTATIC, ownerClass, symbol.getName(), symbol.getDescriptor());
        } else {
            curMethodVisitor.visitVarInsn(TypeUtils.getVarLoadCode(symbol.getType()), symbol.getOffset());
        }
        return null;
    }
}
