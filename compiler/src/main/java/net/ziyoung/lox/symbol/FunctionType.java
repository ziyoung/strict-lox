package net.ziyoung.lox.symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionType implements Type {
    private final String name;
    private List<String> argNameList = Collections.emptyList();
    private List<Type> argTypeList = Collections.emptyList();
    private final Type returnType;

    public FunctionType(String name, Type returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public void addArg(String name, Type type) {
        if (argTypeList.size() != 0) {
            argTypeList = new ArrayList<>();
            argNameList = new ArrayList<>();
        }
        argNameList.add(name);
        argTypeList.add(type);
    }

    public List<String> getArgNameList() {
        return argNameList;
    }

    public List<Type> getArgTypeList() {
        return argTypeList;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getIndex() {
        return TypeKind.FUNCTION.getIndex();
    }

    @Override
    public int getSlotSize() {
        return 1;
    }
}