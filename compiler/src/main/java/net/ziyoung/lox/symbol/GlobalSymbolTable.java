package net.ziyoung.lox.symbol;

import net.ziyoung.lox.builtin.PrintFunction;

import java.util.LinkedHashMap;
import java.util.Map;

public class GlobalSymbolTable {
    private final Map<String, Type> typeMap;
    private final SymbolTable global;

    public GlobalSymbolTable() {
        typeMap = new LinkedHashMap<>();
        for (PrimitiveType type : PrimitiveType.values()) {
            typeMap.put(type.name(), type);
        }
        global = new SymbolTable(null);
        defineSymbol(new FunctionSymbol("print", PrintFunction.functionTypeList));
    }

    public void defineType(Type type) {
        typeMap.put(type.getName(), type);
    }

    public Type resolveType(String name) {
        return typeMap.get(name);
    }

    public void defineSymbol(Symbol symbol) {
        global.define(symbol);
    }

    public Symbol resolveSymbol(String name) {
        return global.resolve(name);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("types:\n");
        typeMap.values().forEach(type -> stringBuilder.append("\t- ").append(type.getName()).append("\n"));

        stringBuilder.append("symbols:\n");
        stringBuilder.append(global);
        return stringBuilder.toString();
    }
}
