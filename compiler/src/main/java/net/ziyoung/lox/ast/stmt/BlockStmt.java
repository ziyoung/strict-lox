package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.AstVisitor;
import net.ziyoung.lox.ast.Stmt;

import java.util.List;

public class BlockStmt extends Stmt {
    private final List<Stmt> stmtList;

    public BlockStmt(List<Stmt> stmtList) {
        this.stmtList = stmtList;
    }

    public List<Stmt> getStmtList() {
        return stmtList;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitBlockStmt(this);
    }
}
