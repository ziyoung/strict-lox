package net.ziyoung.lox.symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Symbol> symbolMap = new LinkedHashMap<>();
    private final SymbolTable enclosing;

    public SymbolTable(SymbolTable enclosing) {
        this.enclosing = enclosing;
    }

    public void define(Symbol symbol) {
        symbolMap.put(symbol.getName(), symbol);
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        symbolMap.values().forEach(symbol -> stringBuilder
                .append("\t- ")
                .append(symbol.getName())
                .append(": ")
                .append(symbol.getName())
        );
        return stringBuilder.toString();
    }
}
