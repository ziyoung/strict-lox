package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeUtils;

public class Symbol {
    private final String name;
    private final Type type;
    // For a class filed, nextOffset is -1.
    private int offset = -1;

    public Symbol(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    public int getLoadCode() {
        return TypeUtils.getVarLoadCode(type);
    }

    public String getDescriptor() {
        return type.getDescriptor();
    }
}
