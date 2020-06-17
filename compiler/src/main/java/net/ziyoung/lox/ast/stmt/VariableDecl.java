package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.TypeNode;

public class VariableDecl extends Decl {
    private final String name;
    private final TypeNode typeNode;
    private final Expr initializer;

    public VariableDecl(String name, TypeNode typeNode, Expr initializer) {
        this.name = name;
        this.typeNode = typeNode;
        this.initializer = initializer;
    }

    public String getName() {
        return name;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    public Expr getInitializer() {
        return initializer;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitVariableDecl(this);
    }
}
