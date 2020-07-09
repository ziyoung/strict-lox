package net.ziyoung.lox.semantic;

import net.ziyoung.lox.ast.Position;

public class SemanticError {
    private final Position position;
    private final String msg;

    public SemanticError(Position position, String msg) {
        this.position = position;
        this.msg = msg;
    }

    @Override
    public String toString() {
        String string = position != null ? position.toString() : "";
        return string + " " + msg;
    }
}
