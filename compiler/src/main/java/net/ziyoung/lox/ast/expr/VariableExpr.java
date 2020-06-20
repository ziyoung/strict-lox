package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;

import java.util.Map;

public class VariableExpr extends Expr {
    private final Identifier id;

    public VariableExpr(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitVariableExpr(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("Variable");
    }
}
