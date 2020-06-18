package net.ziyoung.lox.ast.stmt;

import net.ziyoung.lox.ast.Stmt;

import java.util.Map;

public abstract class Decl extends Stmt {
    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("Declaration");
    }
}
