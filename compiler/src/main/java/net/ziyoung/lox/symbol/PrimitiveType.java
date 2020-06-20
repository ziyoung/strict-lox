package net.ziyoung.lox.symbol;

public enum PrimitiveType implements Type {
    BOOL(TypeKind.BOOL, 1),
    INT(TypeKind.INT, 1), LONG(TypeKind.LONG, 2),
    FLOAT(TypeKind.FLOAT, 1), DOUBLE(TypeKind.DOUBLE, 2),
    STRING(TypeKind.STRING, 1);

    private final TypeKind kind;
    private final int slotSize;

    PrimitiveType(TypeKind kind, int slotSize) {
        this.kind = kind;
        this.slotSize = slotSize;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public int getIndex() {
        return kind.getIndex();
    }

    @Override
    public int getSlotSize() {
        return slotSize;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
