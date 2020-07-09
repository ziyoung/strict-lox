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
import net.ziyoung.lox.type.TypeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

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
        curFunctionSymbol.setStackSize(Math.max(stackSize, size));
    }

    private void updateFunctionLocalSize(int size) {
        int localSize = curFunctionSymbol.getLocalSize();
        curFunctionSymbol.setLocalSize(Math.max(localSize, size));
    }

    @Override
    public Void visitBlockStmt(BlockStmt node) {
        SymbolTable preSymbolTable = curSymbolTable;
        ExprTypeResolver prevExprTypeResolver = curExprTypeResolver;
        try {
            curSymbolTable = new SymbolTable(curSymbolTable, curSymbolTable.getNextOffset());
            curExprTypeResolver = new ExprTypeResolver(curSymbolTable, semanticErrorList, typeChecker);
            nodeSymbolTableMap.put(node, curSymbolTable);
            logger.info("visitBlockStmt: curSymbolTable and curExprVisitor are updated");

            node.getStmtList().forEach(this::visitStmt);

            logger.info("curExprTypeResolver stack size {}", curExprTypeResolver.getStackSize());
            updateFunctionStackSize(curExprTypeResolver.getStackSize());
            updateFunctionLocalSize(curSymbolTable.getNextOffset());
        } finally {
            curSymbolTable = preSymbolTable;
            curExprTypeResolver = prevExprTypeResolver;
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
        Objects.requireNonNull(functionSymbol, "FunctionSymbol is required");

        curFunctionSymbol = functionSymbol;
        SymbolTable prevSymbolTable = curSymbolTable;
        ExprTypeResolver prevExprTypeResolver = curExprTypeResolver;

        try {
            // FIXME: use a better way.
            int initOffset = name.equals("main") ? 1 : 0;
            curSymbolTable = new SymbolTable(prevSymbolTable, initOffset);
            nodeSymbolTableMap.put(node, curSymbolTable);
            curExprTypeResolver = new ExprTypeResolver(curSymbolTable, semanticErrorList, typeChecker);
            logger.info("visitFunctionDecl: curSymbolTable and curExprVisitor are updated");

            FunctionType functionType = (FunctionType) functionSymbol.getType();
            functionType.getParameterList().forEach(parameter -> {
                Symbol symbol = new Symbol(parameter.getName(), parameter.getType());
                curSymbolTable.define(symbol);
            });
            visitBlockStmt(node.getBody());
        } finally {
            curSymbolTable = prevSymbolTable;
            curFunctionSymbol = null;
            curExprTypeResolver = prevExprTypeResolver;
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
        if (curSymbolTable.contains(id.getName())) {
            semanticErrorList.add(id.getPosition(), String.format("Variable %s has been declared", id.getName()));
        }

        Type lhsType = typeChecker.check(node.getTypeNode());
        Type rhsType = null;

        Expr initializer = node.getInitializer();
        if (initializer != null) {
            rhsType = curExprTypeResolver.visitExpr(node.getInitializer());
        }

        Type promptType = typeChecker.validateAssign(id, lhsType, rhsType);
        node.setPromptType(promptType);
        if (!node.isTopLevel()) {
            updateFunctionStackSize(TypeUtils.getTypeSize(lhsType));
        }
        curExprTypeResolver.updateStackSize(lhsType);
        Symbol symbol = new Symbol(id.getName(), lhsType);
        curSymbolTable.define(symbol);
        return null;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        curSymbolTable = globalSymbolTable.getGlobal();
        curExprTypeResolver = new ExprTypeResolver(curSymbolTable, semanticErrorList, typeChecker);
        logger.info("visitCompilationUnit: curSymbolTable and curExprVisitor are updated");

        node.getDeclList().forEach(this::visitDecl);

        FunctionType functionType = new FunctionType("<clinit>", null);
        String curClass = node.getQualifiedName();
        FunctionSymbol functionSymbol = new FunctionSymbol("<clinit>", curClass, true, functionType);
        functionSymbol.setStackSize(curExprTypeResolver.getStackSize());
        functionSymbol.setLocalSize(curSymbolTable.getNextOffset());
        curSymbolTable.define(functionSymbol);
        return null;
    }
}
