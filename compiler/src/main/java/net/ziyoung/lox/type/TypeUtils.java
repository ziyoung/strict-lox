package net.ziyoung.lox.type;

import org.objectweb.asm.Opcodes;

public class TypeUtils {

    private final static int[] varLoadCodes = new int[]{
            Opcodes.ILOAD, // bool
            Opcodes.ILOAD, // int
            Opcodes.LLOAD, // long
            Opcodes.FLOAD, // float
            Opcodes.DLOAD, // double
            Opcodes.ALOAD, // string
            -1,            // function
            Opcodes.ALOAD, // class
            Opcodes.ALOAD  // null
    };

    public static int getVarLoadCode(Type type) {
        int code = varLoadCodes[type.getIndex()];
        if (code == -1) {
            throw new RuntimeException("Function can't be used as a variable");
        }
        return code;
    }

}
