package net.ziyoung.lox.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class FunctionType implements Type {

    public static class Parameter {
        private final String name;
        private final Type type;

        public Parameter(String name, Type type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public Type getType() {
            return type;
        }
    }

    private final String name;
    private List<Parameter> parameterList = Collections.emptyList();
    private final Type returnType;

    public FunctionType(String name, Type returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public void addArg(String name, Type type) {
        if (parameterList.size() == 0) {
            parameterList = new ArrayList<>();
        }
        parameterList.add(new Parameter(name, type));
    }

    public boolean containsArgName(String name) {
        for (Parameter parameter : parameterList) {
            if (parameter.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public Type getReturnType() {
        return returnType;
    }

    public String getParameterDescriptor() {
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
        parameterList.forEach(parameter -> stringJoiner.add(parameter.getType().getName()));
        return stringJoiner.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescriptor() {
        String returnDescriptor = returnType == null ? "V" : returnType.getDescriptor();
        return getParameterDescriptor() + returnDescriptor;
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
