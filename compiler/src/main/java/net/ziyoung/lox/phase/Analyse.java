package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.*;
import net.ziyoung.lox.ast.stmt.*;
import net.ziyoung.lox.phase.visitor.ExprTypeResolver;
import net.ziyoung.lox.semantic.SemanticErrorList;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.FunctionType;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.IdentityHashMap;
import java.util.Map;

public class Analyse extends AstBaseVisitor<Void> {

    private static final Logger logger = LoggerFactory.getLogger(Analyse.class);

    private final GlobalSymbolTable globalSymbolTable;
    private final SemanticErrorList semanticErrorList;
    private final TypeChecker typeChecker;
    private final Map<Node, SymbolTable> nodeSymbolTableMap = new IdentityHashMap<>();
    private SymbolTable curSymbolTable;
    private ExprTypeResolver curExprTypeResolver;
    private FunctionSymbol curFunctionSymbol;

    public Analyse(AnalyseContext analyseContext) {
        this.globalSymbolTable = analyseContext.getGlobalSymbolTable();
        this.semanticErrorList = analyseContext.getSemanticErrorList();
        this.typeChecker = analyseContext.getTypeChecker();
    }

    public Map<Node, SymbolTable> getNodeSymbolTableMap() {
        return nodeSymbolTableMap;
    }

    private void updateFunctionStackSize(int size) {
        int stackSize = curFunctionSymbol.getStackSize();
        logger.info("size is {} stack size is {}", size, stackSize);
        curFunctionSymbol.setStackSize(Math.max(stackSize, size));
    }

    private void updateFunctionLocalSize(int size) {
        int localSize = curFunctionSymbol.getLocalSize();
        logger.info("size is {} local size is {}", size, localSize);
        curFunctionSymbol.setLocalSize(Math.max(localSize, size));
    }

    @Override
    public Void visitBlockStmt(BlockStmt node) {
        SymbolTable preSymbolTable = curSymbolTable;
        try {
            curSymbolTable = new SymbolTable(curSymbolTable, curSymbolTable.getNextOffset());
            curExprTypeResolver = new ExprTypeResolver(curSymbolTable, semanticErrorList, typeChecker);
            nodeSymbolTableMap.put(node, curSymbolTable);
            logger.info("curSymbolTable and curExprVisitor are updated in visitBlockStmt");

            node.getStmtList().forEach(this::visitStmt);

            updateFunctionStackSize(curExprTypeResolver.getStackSize());
            updateFunctionLocalSize(curSymbolTable.getNextOffset());
        } finally {
            curSymbolTable = preSymbolTable;
        }
        return null;
    }

    @Override
    public Void visitClassDecl(ClassDecl node) {
        return super.visitClassDecl(node);
    }

    @Override
    public Void visitExpressionStmt(ExpressionStmt node) {
        if (node.getExpr().usedAsStmt()) {
            curExprTypeResolver.visitExpr(node.getExpr());
        } else {
            semanticErrorList.add(node.getPosition(), "Expression can't be used as statement");
        }
        return null;
    }

    @Override
    public Void visitForStmt(ForStmt node) {
        return super.visitForStmt(node);
    }

    @Override
    public Void visitFunctionDecl(FunctionDecl node) {
        String name = node.getId().getName();
        FunctionSymbol functionSymbol = (FunctionSymbol) curSymbolTable.resolve(name);
        if (functionSymbol == null) {
            throw new RuntimeException("FunctionSymbol is required");
        }

        curFunctionSymbol = functionSymbol;
        SymbolTable prevSymbolTable = curSymbolTable;
        try {
            curSymbolTable = new SymbolTable(prevSymbolTable, 0);
            nodeSymbolTableMap.put(node, curSymbolTable);
            curExprTypeResolver = new ExprTypeResolver(curSymbolTable, semanticErrorList, typeChecker);

            FunctionType functionType = (FunctionType) functionSymbol.getType();
            functionType.getParameterList().forEach(parameter -> {
                Symbol symbol = new Symbol(parameter.getName(), parameter.getType());
                curSymbolTable.define(symbol);
            });
            visitBlockStmt(node.getBody());
        } finally {
            curSymbolTable = prevSymbolTable;
            // Rest after visit ends.
            curFunctionSymbol = null;
        }
        return null;
    }

    @Override
    public Void visitIfStmt(IfStmt node) {
        return super.visitIfStmt(node);
    }

    @Override
    public Void visitMethodDecl(MethodDecl node) {
        return super.visitMethodDecl(node);
    }

    @Override
    public Void visitPropertyDecl(PropertyDecl node) {
        return super.visitPropertyDecl(node);
    }

    @Override
    public Void visitReturnStmt(ReturnStmt node) {
        return super.visitReturnStmt(node);
    }

    @Override
    public Void visitVariableDecl(VariableDecl node) {
        Identifier id = node.getId();
        if (curSymbolTable.resolve(id.getName()) != null) {
            semanticErrorList.add(id.getPosition(), String.format("Variable %s has been declared", id.getName()));
        }

        Type lhsType = typeChecker.check(node.getTypeNode());
        Type rhsType = null;

        Expr initializer = node.getInitializer();
        if (initializer != null) {
            rhsType = curExprTypeResolver.visitExpr(node.getInitializer());
        }
        typeChecker.validateAssign(id, lhsType, rhsType);

        Symbol symbol = new Symbol(id.getName(), lhsType);
        curSymbolTable.define(symbol);
        return null;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        curSymbolTable = globalSymbolTable.getGlobal();
        curExprTypeResolver = new ExprTypeResolver(curSymbolTable, semanticErrorList, typeChecker);
        logger.info("curSymbolTable and curExprVisitor are updated in visitCompilationUnit");

        node.getDeclList().forEach(this::visitDecl);
        return null;
    }
}
