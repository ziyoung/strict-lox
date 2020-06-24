package net.ziyoung.lox.ast;

public enum LiteralType {
    BOOL("bool"),
    INT("int"),
    DOUBLE("double"),
    STRING("string"),
    NULL("null");

    private final String name;

    LiteralType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
