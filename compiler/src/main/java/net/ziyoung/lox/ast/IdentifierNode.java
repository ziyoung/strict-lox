package net.ziyoung.lox.ast;

public class IdentifierNode extends Node {
    private final String name;

    public IdentifierNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitIdentifierNode(this);
    }
}
