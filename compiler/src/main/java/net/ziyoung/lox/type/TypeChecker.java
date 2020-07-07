package net.ziyoung.lox.type;

import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;

import static net.ziyoung.lox.type.PrimitiveType.*;
import static net.ziyoung.lox.type.PrimitiveType.DOUBLE;

public class TypeChecker {

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

    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;

    public TypeChecker(GlobalSymbolTable globalSymbolTable, SemanticErrorList semanticErrorList) {
        this.globalSymbolTable = globalSymbolTable;
        this.semanticErrorList = semanticErrorList;
    }

    public Type check(TypeNode typeNode) {
        if (typeNode == null) {
            return null;
        }
        Type type = globalSymbolTable.resolveType(typeNode);
        if (type == null) {
            semanticErrorList.add(typeNode.getPosition(), String.format("Unknown type '%s'", typeNode.getName()));
        }
        return type;
    }

    public void validateAssign(Node node, Type lhsType, Type rhsType) {
        if (lhsType == null || rhsType == null) {
            return;
        }
        // FIXME: support type prompt.
        if (!lhsType.equals(rhsType)) {
            semanticErrorList.add(node.getPosition(), String.format("Type '%s' is not assignable to type '%s'", rhsType, lhsType));
        }
    }

    public Type validateArithmetic(Node node, Type lhsType, Type rhsType) {
        if (lhsType == null || rhsType == null) {
            return null;
        }
        Type resultType = arithmeticResultType[lhsType.getIndex()][rhsType.getIndex()];
        if (resultType == null) {
            semanticErrorList.add(node.getPosition(), String.format("Invalid operation: mismatched types '%s' and '%s'", lhsType, rhsType));
        }
        return resultType;
    }

    public Type validateUnary(Node node, String op, Type rhsType) {
        if (op.equals("!") && rhsType != PrimitiveType.BOOL) {
            semanticErrorList.add(node.getPosition(), "Expect boolean after '!'");
            return BOOL;
        }
        if (op.equals("-") && !TypeUtils.isNumeric(rhsType)) {
            semanticErrorList.add(node.getPosition(), "Expect number after '-'");
        }
        return rhsType;
    }
}
