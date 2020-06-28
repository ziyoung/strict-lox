package net.ziyoung.lox.phase.context;

import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.type.TypeChecker;

public class AnalyseContext {

    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;

    public AnalyseContext(GlobalSymbolTable globalSymbolTable, SemanticErrorList semanticErrorList, TypeChecker typeChecker) {
        this.globalSymbolTable = globalSymbolTable;
        this.semanticErrorList = semanticErrorList;
        this.typeChecker = typeChecker;
    }

    public GlobalSymbolTable getGlobalSymbolTable() {
        return globalSymbolTable;
    }

    public SemanticErrorList getSemanticErrorList() {
        return semanticErrorList;
    }

    public TypeChecker getTypeChecker() {
        return typeChecker;
    }
}
