package net.ziyoung.lox.ast;

public class TypeNode extends Node {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitTypeNode(this);
    }
}
