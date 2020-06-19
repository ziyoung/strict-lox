package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;

import java.util.Map;

public class AssignExpr extends BinaryExpr {
    public AssignExpr(Expr lhs, Identifier op, Expr rhs) {
        super(lhs, op, rhs);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitAssignExpr(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("AssignExpression");
    }
}
