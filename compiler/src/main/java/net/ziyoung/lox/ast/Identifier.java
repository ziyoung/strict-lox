package net.ziyoung.lox.ast;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Map;

public class Identifier extends Node {
    public static Identifier from(TerminalNode node) {
        Identifier identifier = new Identifier(node.getText());
        identifier.setPosition(node);
        return identifier;
    }

    public static Identifier from(Token token) {
        Identifier identifier = new Identifier(token.getText());
        identifier.setPosition(token);
        return identifier;
    }

    private final String name;

    public Identifier(String name) {
        this.name = name;
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
