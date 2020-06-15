package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Stmt;

public class IfStmt extends Stmt {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitIfStmt(this);
    }
}
