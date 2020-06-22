package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.Type;

public class Symbol {
    private final String name;
    private final Type type;

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
}
