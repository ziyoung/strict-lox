package net.ziyoung.lox.builtin;

import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.PrimitiveType;
import net.ziyoung.lox.type.Type;

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
        FunctionType functionType = new FunctionType("print", null);
        functionType.addArg("arg0", type);
        return functionType;
    }
}
