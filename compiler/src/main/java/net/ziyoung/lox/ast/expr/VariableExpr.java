package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;

public class VariableExpr extends Expr {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitVariableExpr(this);
    }
}