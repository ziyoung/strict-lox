package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;

import java.util.Map;

public class UnaryExpr extends Expr {

    private final Identifier op;
    private final Expr rhs;

    public UnaryExpr(Identifier op, Expr rhs) {
        this.op = op;
        this.rhs = rhs;
    }

    public Identifier getOp() {
        return op;
    }

    public Expr getRhs() {
        return rhs;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitUnaryExpr(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("UnaryExpression");
    }

    @Override
    public String toString() {
        return op.getName() + rhs.toString();
    }
}
