package net.ziyoung.lox.ast;

public class TypeNode implements Node {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitTypeNode(this);
    }
}
