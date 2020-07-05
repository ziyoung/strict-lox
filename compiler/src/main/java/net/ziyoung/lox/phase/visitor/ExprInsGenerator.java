package net.ziyoung.lox.phase.visitor;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.expr.BinaryExpr;
import net.ziyoung.lox.ast.expr.CallExpr;
import net.ziyoung.lox.ast.expr.UnaryExpr;
import net.ziyoung.lox.ast.expr.VariableExpr;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ExprInsGenerator extends AstBaseVisitor<Void> {

    private final SymbolTable curSymbolTable;
    private final MethodVisitor curMethodVisitor;

    public ExprInsGenerator(SymbolTable curSymbolTable, MethodVisitor curMethodVisitor) {
        this.curSymbolTable = curSymbolTable;
        this.curMethodVisitor = curMethodVisitor;
    }

    public void visitDefaultInitializer(Type type) {
        curMethodVisitor.visitInsn(Opcodes.ICONST_0);
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
        curMethodVisitor.visitVarInsn(symbol.getLoadCode(), symbol.getOffset());
        return null;
    }
}
