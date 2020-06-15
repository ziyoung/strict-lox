package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;

public class GroupExpr extends Expr {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitGroupExpr(this);
    }
}
