package net.ziyoung.lox.type;

public interface Type {
    String getName();

    String getDescriptor();

    int getIndex();

    int getSlotSize();
}
