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
    private Type evalType;

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

    public void setLhsPromotionType(Type lhsPromotionType) {
        this.lhsPromotionType = lhsPromotionType;
    }

    public Type getRhsPromotionType() {
        return rhsPromotionType;
    }

    public void setRhsPromotionType(Type rhsPromotionType) {
        this.rhsPromotionType = rhsPromotionType;
    }

    public Type getEvalType() {
        return evalType;
    }

    public void setEvalType(Type evalType) {
        this.evalType = evalType;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitBinaryExpr(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("BinaryExpression");
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", lhs, op.getName(), rhs);
    }
}
