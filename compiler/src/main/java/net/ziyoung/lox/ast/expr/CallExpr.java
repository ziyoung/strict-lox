package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;

import java.util.List;

public class CallExpr extends Expr {
    private final Expr fun;
    private final List<Expr> argumentList;

    public CallExpr(Expr fun, List<Expr> argumentList) {
        this.fun = fun;
        this.argumentList = argumentList;
    }

    public Expr getFun() {
        return fun;
    }

    public List<Expr> getArgumentList() {
        return argumentList;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCallExpr(this);
    }
}
