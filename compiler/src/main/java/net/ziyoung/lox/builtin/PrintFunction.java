package net.ziyoung.lox.builtin;

import net.ziyoung.lox.symbol.FunctionType;
import net.ziyoung.lox.symbol.PrimitiveType;
import net.ziyoung.lox.symbol.Type;

import java.util.ArrayList;
import java.util.List;

public class PrintFunction {
    public final static List<FunctionType> functionTypeList = getGenericFunctionList();

    private static List<FunctionType> getGenericFunctionList() {
        List<FunctionType> functionTypeList = new ArrayList<>(PrimitiveType.values().length);
        for (PrimitiveType type : PrimitiveType.values()) {
            functionTypeList.add(getPrintFunction(type));
        }
        return functionTypeList;
    }

    private static FunctionType getPrintFunction(Type type) {
        FunctionType functionType = new FunctionType("print_" + type.getName(), null);
        functionType.addArg("arg0", type);
        return functionType;
    }


}