package net.ziyoung.lox.ast.expr;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.TypeNode;

import java.util.Map;

public class Parameter extends Expr {
    private final Identifier id;
    private final TypeNode typeNode;

    public Parameter(Identifier id, TypeNode typeNode) {
        this.id = id;
        this.typeNode = typeNode;
    }

    public Identifier getId() {
        return id;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitParameter(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("Parameter");
    }
}
