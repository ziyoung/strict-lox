package net.ziyoung.lox.type;

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
        Type type = globalSymbolTable.resolveType(typeNode);
        if (type == null) {
            semanticErrorList.add(typeNode.getPosition(), "unknown type " + typeNode.getName());
        }
        return type;
    }
}
