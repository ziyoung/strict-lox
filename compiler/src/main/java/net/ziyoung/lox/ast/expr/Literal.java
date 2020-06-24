package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.LiteralType;
import net.ziyoung.lox.type.Type;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Map;

public class Literal extends Expr {
    public static Literal of(TerminalNode node, LiteralType type) {
        Literal literal = new Literal(node.getText(), type);
        literal.setPosition(node);
        return literal;
    }

    private final String value;
    private final LiteralType literalType;
    private Type evalType;

    public Literal(String value, LiteralType literalType) {
        this.value = value;
        this.literalType = literalType;
    }

    public String getValue() {
        return value;
    }

    public LiteralType getLiteralType() {
        return literalType;
    }

    public Type getEvalType() {
        return evalType;
    }

    public void setEvalType(Type evalType) {
        this.evalType = evalType;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitLiteral(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("Literal");
    }
}
