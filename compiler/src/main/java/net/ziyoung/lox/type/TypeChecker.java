package net.ziyoung.lox.type;

import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.ast.TypeNode;
import net.ziyoung.lox.phase.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;

public class TypeChecker {
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
        if (!lhsType.equals(rhsType)) {
            semanticErrorList.add(node.getPosition(), String.format("type '%s' is not assignable to type '%s'", rhsType, lhsType));
        }
    }
}
