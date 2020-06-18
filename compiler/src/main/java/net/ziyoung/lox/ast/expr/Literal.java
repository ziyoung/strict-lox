package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.LiteralType;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Map;

public class Literal extends Expr {
    public static Literal from(TerminalNode node, LiteralType type) {
        Literal literal = new Literal(node.getText(), type);
        literal.setPosition(node);
        return literal;
    }

    private final String value;
    private final LiteralType type;

    public Literal(String value, LiteralType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public LiteralType getType() {
        return type;
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
