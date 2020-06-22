package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.Type;

public class LocalSymbol extends Symbol {
    private final int offset;

    public LocalSymbol(String name, Type type, int offset) {
        super(name, type);
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
