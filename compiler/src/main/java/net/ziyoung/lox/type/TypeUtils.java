package net.ziyoung.lox.type;

import org.objectweb.asm.Opcodes;

import static net.ziyoung.lox.type.PrimitiveType.*;

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

    public final static Type[][] promoteFromTo = new Type[][]{
            /*          bool int long float double string class */
            /* bool */{null, null, null, null, null, null, null},
            /* int */{null, null, LONG, FLOAT, DOUBLE, null, null},
            /* long */{null, null, null, null, DOUBLE, null, null},
            /* float */{null, null, null, null, DOUBLE, null, null},
            /* double */{null, null, null, null, null, null, null},
            /* string */{null, null, null, null, null, null, null},
            /* class */{null, null, null, null, null, null, null}
    };

    public static int getVarLoadCode(Type type) {
        int code = varLoadCodes[type.getIndex()];
        if (code == -1) {
            throw new RuntimeException("Function can't be used as a variable");
        }
        return code;
    }

    public static boolean isNumeric(Type type) {
        if (type == null) {
            return false;
        }
        return type == PrimitiveType.INT || type == PrimitiveType.LONG ||
                type == PrimitiveType.FLOAT || type == PrimitiveType.DOUBLE;
    }

    public static Type getPromoteType(Type a, Type b) {
        if (a == null || b == null) {
            return null;
        }
        return promoteFromTo[a.getIndex()][b.getIndex()];
    }

}
