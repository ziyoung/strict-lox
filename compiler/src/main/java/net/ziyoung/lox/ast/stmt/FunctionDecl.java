package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Identifier;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.ast.expr.ParameterExpr;

import java.util.List;
import java.util.Map;

public class FunctionDecl extends Decl {
    private final Identifier id;
    private final List<ParameterExpr> parameterExprList;
    private final TypeNode returnTypeNode;
    private final BlockStmt body;

    public FunctionDecl(Identifier id, List<ParameterExpr> parameterExprList, TypeNode returnTypeNode, BlockStmt body) {
        this.id = id;
        this.parameterExprList = parameterExprList;
        this.returnTypeNode = returnTypeNode;
        this.body = body;
    }

    public Identifier getId() {
        return id;
    }

    public List<ParameterExpr> getParameterExprList() {
        return parameterExprList;
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
