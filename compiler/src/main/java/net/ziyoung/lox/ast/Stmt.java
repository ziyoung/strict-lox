package net.ziyoung.lox.ast;

import java.util.Map;

public abstract class Stmt extends Node {
    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("Statement");
    }
}
