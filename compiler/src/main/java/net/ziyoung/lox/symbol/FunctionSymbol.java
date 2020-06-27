package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.OverloadFunctionType;

import java.util.List;

public class FunctionSymbol extends Symbol {

    public FunctionSymbol(String name, FunctionType type) {
        super(name, type);
    }

    public FunctionSymbol(String name, List<FunctionType> functionTypeList) {
        super(name, new OverloadFunctionType(name, functionTypeList));
    }
}
