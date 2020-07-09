package net.ziyoung.lox.type;

import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.ziyoung.lox.type.PrimitiveType.BOOL;

public class TypeChecker {

    private static final Logger logger = LoggerFactory.getLogger(TypeChecker.class);

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

    public Type validateAssign(Node node, Type lhsType, Type rhsType) {
        if (lhsType == null || rhsType == null) {
            return null;
        }
        Type resultType = TypeUtils.getAssignType(lhsType, rhsType);
        if (resultType == null) {
            semanticErrorList.add(node.getPosition(), String.format("Type '%s' is not assignable to type '%s'", rhsType, lhsType));
        }
        return TypeUtils.getPromoteType(rhsType, lhsType);
    }

    public Type validateArithmetic(Node node, Type lhsType, Type rhsType) {
        if (lhsType == null || rhsType == null) {
            return null;
        }
        Type resultType = TypeUtils.getArithmeticType(lhsType, rhsType);
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
