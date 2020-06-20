package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;

import java.util.Map;

public class GroupExpr extends Expr {
    private final Expr expr;

    public GroupExpr(Expr expr) {
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitGroupExpr(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("GroupExpression");
    }
}
