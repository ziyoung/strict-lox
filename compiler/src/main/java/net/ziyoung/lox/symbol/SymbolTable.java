package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.Type;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Symbol> symbolMap = new LinkedHashMap<>();
    private final SymbolTable enclosing;
    // For a class symbol table, nextOffset is -1.
    private int nextOffset = -1;

    public SymbolTable(SymbolTable enclosing) {
        this.enclosing = enclosing;
    }

    public SymbolTable(SymbolTable enclosing, int nextOffset) {
        this.enclosing = enclosing;
        this.nextOffset = nextOffset;
    }

    public void define(Symbol symbol) {
        symbolMap.put(symbol.getName(), symbol);
        if (nextOffset != -1) {
            symbol.setOffset(nextOffset);
            Type type = symbol.getType();
            nextOffset += type == null ? 1 : type.getSlotSize();
        }
    }

    public Symbol resolve(String name) {
        Symbol symbol = symbolMap.get(name);
        if (symbol != null) {
            return symbol;
        }
        if (enclosing != null) {
            return enclosing.resolve(name);
        }
        return null;
    }

    public boolean contains(String name) {
        return symbolMap.get(name) != null;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        symbolMap.values().forEach(symbol -> stringBuilder
                .append("\t- ")
                .append(symbol.getName())
                .append("\n")
        );
        return stringBuilder.toString();
    }
}
