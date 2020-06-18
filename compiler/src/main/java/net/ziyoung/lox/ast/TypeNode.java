package net.ziyoung.lox.ast;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Map;

public class TypeNode extends Node {
    public static TypeNode from(ParserRuleContext context) {
        if (context == null) {
            return null;
        }
        TypeNode typeNode = new TypeNode(context.getText());
        typeNode.setPosition(context);
        return typeNode;
    }

    private String name;

    public TypeNode(String name) {
        this.name = name;
    }

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

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("TypeNode");
    }
}
