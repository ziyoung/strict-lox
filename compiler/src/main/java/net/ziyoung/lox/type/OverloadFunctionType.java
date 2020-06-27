package net.ziyoung.lox.type;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OverloadFunctionType implements Type {

    private final String name;
    private final List<FunctionType> functionTypeList;

    public OverloadFunctionType(String name, List<FunctionType> functionTypeList) {
        this.name = name;
        this.functionTypeList = functionTypeList;
    }

    public List<FunctionType> getFunctionTypeList() {
        return functionTypeList;
    }

    public FunctionType getFunctionType(String signature) {
        return functionTypeList.stream()
                .filter(functionType1 -> functionType1.getParameterSignature().equals(signature))
                .findFirst()
                .orElse(null);
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
