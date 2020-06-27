package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.type.Type;

import java.util.Map;

public class BinaryExpr extends Expr {

    private final Expr lhs;
    private final Identifier op;
    private final Expr rhs;
    private Type lhsPromotionType;
    private Type rhsPromotionType;

    public BinaryExpr(Expr lhs, Identifier op, Expr rhs) {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
    }

    public Expr getLhs() {
        return lhs;
    }

    public Identifier getOp() {
        return op;
    }

    public Expr getRhs() {
        return rhs;
    }

    public Type getLhsPromotionType() {
        return lhsPromotionType;
    }

    public Type getRhsPromotionType() {
        return rhsPromotionType;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitBinaryExpr(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("BinaryExpression");
    }
}
