package net.ziyoung.lox.symbol;

import java.util.List;

public class FunctionSymbol extends Symbol {
    private boolean overloaded = false;
    private List<FunctionType> functionTypeList;

    public FunctionSymbol(String name, FunctionType type) {
        super(name, type);
    }

    public FunctionSymbol(String name, List<FunctionType> functionTypeList) {
        super(name, null);
        this.functionTypeList = functionTypeList;
        overloaded = true;
    }

    public boolean isOverloaded() {
        return overloaded;
    }

    public List<FunctionType> getFunctionTypeList() {
        return functionTypeList;
    }
}
