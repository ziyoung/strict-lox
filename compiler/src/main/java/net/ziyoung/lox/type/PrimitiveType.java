package net.ziyoung.lox.type;

import java.util.Map;

public enum PrimitiveType implements Type {
    BOOL(TypeKind.BOOL, 1),
    INT(TypeKind.INT, 1), LONG(TypeKind.LONG, 2),
    FLOAT(TypeKind.FLOAT, 1), DOUBLE(TypeKind.DOUBLE, 2),
    STRING(TypeKind.STRING, 1);

    private static final Map<TypeKind, String> signatureMap = Map.of(
            TypeKind.BOOL, "Z",
            TypeKind.INT, "I",
            TypeKind.LONG, "J",
            TypeKind.FLOAT, "F",
            TypeKind.DOUBLE, "D",
            TypeKind.STRING, "Ljava/lang/String;"
    );

    private final TypeKind kind;
    private final int slotSize;

    PrimitiveType(TypeKind kind, int slotSize) {
        this.kind = kind;
        this.slotSize = slotSize;
    }

    @Override
    public String getName() {
        return kind.getName();
    }

    @Override
    public String getDescriptor() {
        return signatureMap.get(kind);
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
        return getName();
    }
}
