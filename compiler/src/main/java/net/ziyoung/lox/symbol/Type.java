package net.ziyoung.lox.symbol;

public interface Type {
    String getName();

    int getIndex();

    int getSlotSize();
}
