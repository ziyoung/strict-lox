package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.type.Type;

public class VariableDecl extends Decl {
    private final Identifier id;
    private final TypeNode typeNode;
    private final Expr initializer;
    private Type promptType;
    private boolean topLevel = false;

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

    public Type getPromptType() {
        return promptType;
    }

    public void setPromptType(Type promptType) {
        this.promptType = promptType;
    }

    public boolean isTopLevel() {
        return topLevel;
    }

    public void setTopLevel(boolean topLevel) {
        this.topLevel = topLevel;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitVariableDecl(this);
    }
}
