package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.OverloadFunctionType;

import java.util.List;

public class FunctionSymbol extends Symbol {

    private int stackSize;
    private int localSize;
    private final boolean staticField;
    private final String ownerClass;

    public FunctionSymbol(String name, String ownerClass, boolean staticField, FunctionType type) {
        super(name, type);
        this.ownerClass = ownerClass;
        this.staticField = staticField;
    }

    public FunctionSymbol(String name, String ownerClass, boolean staticField, List<FunctionType> functionTypeList) {
        super(name, new OverloadFunctionType(name, functionTypeList));
        this.ownerClass = ownerClass;
        this.staticField = staticField;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    @Override
    public boolean isFunction() {
        return true;
    }

    @Override
    public boolean isStaticField() {
        return staticField;
    }

    public String getOwnerClass() {
        return ownerClass;
    }

    public int getLocalSize() {
        return localSize;
    }

    public void setLocalSize(int localSize) {
        this.localSize = localSize;
    }
}
