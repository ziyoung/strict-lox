package net.ziyoung.lox.ast;

public interface AstVisitor<R> {
    R visitNode(Node node);
}
