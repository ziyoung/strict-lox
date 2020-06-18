package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.TypeNode;

public class VariableDecl extends Decl {
    private final Identifier id;
    private final TypeNode typeNode;
    private final Expr initializer;

    public VariableDecl(Identifier id, TypeNode typeNode, Expr initializer) {
        this.id = id;
        this.typeNode = typeNode;
        this.initializer = initializer;
    }

    public Identifier getId() {
        return id;
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
