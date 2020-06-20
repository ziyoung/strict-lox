package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;

import java.util.List;
import java.util.Map;

public class CallExpr extends Expr {
    private final Expr callee;
    private final List<Expr> argumentList;

    public CallExpr(Expr callee, List<Expr> argumentList) {
        this.callee = callee;
        this.argumentList = argumentList;
    }

    public Expr getCallee() {
        return callee;
    }

    public List<Expr> getArgumentList() {
        return argumentList;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCallExpr(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("CallExpression");
    }
}
