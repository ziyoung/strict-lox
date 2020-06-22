package net.ziyoung.lox.type;

public enum TypeKind {
    BOOL(0, "bool"),
    INT(1, "int"), LONG(2, "long"),
    FLOAT(3, "float"), DOUBLE(4, "double"),
    STRING(5, "string"),
    FUNCTION(6, "function"),
    CLASS(7, "class"),
    NULL(8, "null");

    private final int index;
    private final String name;

    TypeKind(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
