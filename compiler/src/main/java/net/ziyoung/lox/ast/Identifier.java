package net.ziyoung.lox.ast;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Map;

public class Identifier extends Node {
    public static Identifier of(TerminalNode node) {
        return new Identifier(node);
    }

    public static Identifier of(Token token) {
        return new Identifier(token);
    }

    private final String name;

    public Identifier(String name) {
        this.name = name;
    }

    public Identifier(TerminalNode node) {
        this(node.getText());
        setPosition(node);
    }

    public Identifier(Token token) {
        this(token.getText());
        setPosition(token);
    }

    public String getName() {
        return name;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitIdentifier(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("Identifier");
    }
}
