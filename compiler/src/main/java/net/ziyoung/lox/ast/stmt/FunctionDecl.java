package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.ast.expr.Parameter;

import java.util.List;
import java.util.Map;

public class FunctionDecl extends Decl {
    private final Identifier id;
    private final List<Parameter> parameterList;
    private final TypeNode returnTypeNode;
    private final BlockStmt body;

    public FunctionDecl(Identifier id, List<Parameter> parameterList, TypeNode returnTypeNode, BlockStmt body) {
        this.id = id;
        this.parameterList = parameterList;
        this.returnTypeNode = returnTypeNode;
        this.body = body;
    }

    public Identifier getId() {
        return id;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public TypeNode getReturnTypeNode() {
        return returnTypeNode;
    }

    public BlockStmt getBody() {
        return body;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitFunctionDecl(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("FunctionDeclaration");
    }
}
