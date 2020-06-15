package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;

public class LiteralExpr extends Expr {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitLiteralExpr(this);
    }
}
