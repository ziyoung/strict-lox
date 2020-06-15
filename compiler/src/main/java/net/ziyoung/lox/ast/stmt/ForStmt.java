package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Stmt;

public class ForStmt extends Stmt {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitForStmt(this);
    }
}
