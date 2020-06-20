package net.ziyoung.lox.symbol;

public enum TypeKind {
    BOOL(0),
    INT(1), LONG(2),
    FLOAT(3), DOUBLE(4),
    STRING(5),
    FUNCTION(6),
    CLASS(7),
    NULL(8);

    private final int index;

    TypeKind(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
