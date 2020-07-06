package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.OverloadFunctionType;

import java.util.List;

public class FunctionSymbol extends Symbol {

    private int stackSize;
    private int localSize;

    public FunctionSymbol(String name, FunctionType type) {
        super(name, type);
    }

    public FunctionSymbol(String name, List<FunctionType> functionTypeList) {
        super(name, new OverloadFunctionType(name, functionTypeList));
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public int getLocalSize() {
        return localSize;
    }

    public void setLocalSize(int localSize) {
        this.localSize = localSize;
    }
}
