package net.ziyoung.lox.ast;

public interface Node {
    <R> R accept(AstVisitor<R> visitor);
}
