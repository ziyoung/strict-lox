package net.ziyoung.lox.ast;

import java.util.Map;

public abstract class Expr extends Node {

    public boolean usedAsStmt() {
        return false;
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("Expression");
    }
}
