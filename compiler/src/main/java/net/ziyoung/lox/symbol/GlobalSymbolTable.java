package net.ziyoung.lox.symbol;

import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.builtin.PrintFunction;
import net.ziyoung.lox.type.PrimitiveType;
import net.ziyoung.lox.type.Type;

import java.util.LinkedHashMap;
import java.util.Map;

public class GlobalSymbolTable {

    private final Map<String, Type> typeMap;
    private final SymbolTable global;

    public GlobalSymbolTable() {
        typeMap = new LinkedHashMap<>();
        for (PrimitiveType type : PrimitiveType.values()) {
            typeMap.put(type.getName(), type);
        }
        global = new SymbolTable(null);
        FunctionSymbol functionSymbol = new FunctionSymbol(
                "print",
                "java/io/PrintStream",
                true,
                PrintFunction.functionTypeList
        );
        defineSymbol(functionSymbol);
    }

    public void defineType(Type type) {
        typeMap.put(type.getName(), type);
    }

    public Type resolveType(String name) {
        return typeMap.get(name);
    }

    public Type resolveType(TypeNode node) {
        return resolveType(node.getName());
    }

    public void defineSymbol(Symbol symbol) {
        global.define(symbol);
    }

    public Symbol resolveSymbol(String name) {
        return global.resolve(name);
    }

    public Map<String, Type> getTypeMap() {
        return typeMap;
    }

    public SymbolTable getGlobal() {
        return global;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("types:\n");
        typeMap.values()
                .forEach(type ->
                        stringBuilder.append("\t- ")
                                .append(type.getName())
                                .append("\n")
                );
        stringBuilder.append("symbols:\n");
        stringBuilder.append(global).append("\n");
        return stringBuilder.toString();
    }
}
