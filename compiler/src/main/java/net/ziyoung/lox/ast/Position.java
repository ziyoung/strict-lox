package net.ziyoung.lox.ast;

import org.antlr.v4.runtime.Token;

public class Position {
    private final int line;
    private final int column;

    public Position(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public Position(Token token) {
        this(token.getLine(), token.getCharPositionInLine());
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "line " + line + ":" + column;
    }
}
