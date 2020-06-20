package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Stmt;

public class ExpressionStmt extends Stmt {
    private final Expr expr;

    public ExpressionStmt(Expr expr) {
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitExpressionStmt(this);
    }
}
