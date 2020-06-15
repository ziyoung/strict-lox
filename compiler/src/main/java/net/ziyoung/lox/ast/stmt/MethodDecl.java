package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;

public class MethodDecl extends Decl {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitMethodDecl(this);
    }
}
