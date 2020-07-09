package net.ziyoung.lox.type;

import org.objectweb.asm.Opcodes;

import java.util.Map;
import java.util.Objects;

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

    private final static int[] varStoreCodes = new int[]{
            Opcodes.ISTORE, // bool
            Opcodes.ISTORE, // int
            Opcodes.LSTORE, // long
            Opcodes.FSTORE, // float
            Opcodes.DSTORE, // double
            Opcodes.ASTORE, // string
            -1,            // function
            Opcodes.ASTORE, // class
            Opcodes.ASTORE  // null
    };

    public final static int[][] typeCastCodes = new int[][]{
            /*          bool int long float double string class */
            /* bool */{-1, -1, -1, -1, -1, -1, -1},
            /* int */{-1, -1, Opcodes.I2L, Opcodes.I2F, Opcodes.I2D, -1, -1},
            /* long */{-1, -1, -1, -1, Opcodes.L2D, -1, -1},
            /* float */{-1, -1, -1, -1, Opcodes.F2D, -1, -1},
            /* double */{-1, -1, -1, -1, -1, -1, -1},
            /* string */{-1, -1, -1, -1, -1, -1, -1},
            /* class */{-1, -1, -1, -1, -1, -1, -1}
    };

    public final static Map<String, int[]> arithmeticCodeMap = Map.of(
            /*              bool int long float double string class*/
            "+", new int[]{-1, Opcodes.IADD, Opcodes.LADD, Opcodes.FADD, Opcodes.DADD, -1, -1},
            "-", new int[]{-1, Opcodes.ISUB, Opcodes.LSUB, Opcodes.FSUB, Opcodes.DSUB, -1, -1},
            "*", new int[]{-1, Opcodes.IMUL, Opcodes.LMUL, Opcodes.FMUL, Opcodes.DMUL, -1, -1},
            "/", new int[]{-1, Opcodes.IDIV, Opcodes.LDIV, Opcodes.FDIV, Opcodes.DDIV, -1, -1}
    );

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

    public final static Type[][] arithmeticResultType = new Type[][]{
            /*          bool int long float double string class*/
            /* bool */{null, null, null, null, null, null, null},
            /* int */{null, INT, LONG, FLOAT, DOUBLE, null, null},
            /* long */{null, LONG, LONG, null, DOUBLE, null, null},
            /* float */{null, FLOAT, null, FLOAT, DOUBLE, null, null},
            /* double */{null, DOUBLE, DOUBLE, DOUBLE, DOUBLE, null, null},
            /* string */{null, null, null, null, null, null, null},
            /* class */{null, null, null, null, null, null, null}
    };


    public final static Type[][] assignResultType = new Type[][]{
            /*          bool int long float double string class*/
            /* bool */{BOOL, null, null, null, null, null, null},
            /* int */{null, INT, LONG, null, DOUBLE, null, null},
            /* long */{null, null, LONG, null, null, null, null},
            /* float */{null, null, null, FLOAT, DOUBLE, null, null},
            /* double */{null, null, null, null, DOUBLE, null, null},
            /* string */{null, null, null, null, null, STRING, null},
            /* class */{null, null, null, null, null, null, null}
    };

    public static int getVarLoadCode(Type type) {
        int code = varLoadCodes[type.getIndex()];
        if (code == -1) {
            throw new RuntimeException("Function can't be used as a variable");
        }
        return code;
    }

    public static int getStoreVarCode(Type type) {
        int code = varStoreCodes[type.getIndex()];
        if (code == -1) {
            throw new RuntimeException("Function can't be assigned to a variable");
        }
        return code;
    }

    public static int getTypeSize(Type type) {
        return type == null ? 1 : type.getSlotSize();
    }

    public static boolean isNumeric(Type type) {
        if (type == null) {
            return false;
        }
        return type == PrimitiveType.INT || type == PrimitiveType.LONG ||
                type == PrimitiveType.FLOAT || type == PrimitiveType.DOUBLE;
    }

    public static int getCastCode(Type a, Type b) {
        int op = typeCastCodes[a.getIndex()][b.getIndex()];
        if (op == -1) {
            throw new RuntimeException(String.format("Invalid type %s and %s", a, b));
        }
        return op;
    }

    public static int getArithmeticCode(Type a, String op) {
        int[] codes = arithmeticCodeMap.get(op);
        Objects.requireNonNull(codes, String.format("Unknown operator: %s", op));
        int code = codes[a.getIndex()];
        if (code == -1) {
            throw new RuntimeException(String.format("Unsupported type %s", a));
        }
        return code;
    }

    public static Type getPromoteType(Type a, Type b) {
        if (a == null || b == null) {
            return null;
        }
        return promoteFromTo[a.getIndex()][b.getIndex()];
    }

    public static Type getArithmeticType(Type a, Type b) {
        return arithmeticResultType[a.getIndex()][b.getIndex()];
    }

    public static Type getAssignType(Type a, Type b) {
        return assignResultType[b.getIndex()][a.getIndex()];
    }

}
