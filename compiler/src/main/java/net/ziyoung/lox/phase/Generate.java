package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.ast.stmt.BlockStmt;
import net.ziyoung.lox.ast.stmt.Decl;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.ast.stmt.VariableDecl;
import net.ziyoung.lox.phase.visitor.ExprInsGenerator;
import net.ziyoung.lox.symbol.FunctionSymbol;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import net.ziyoung.lox.type.Type;
import net.ziyoung.lox.type.TypeUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Generate extends AstBaseVisitor<Void> {

    private static final Logger logger = LoggerFactory.getLogger(Generate.class);

    private final GlobalSymbolTable globalSymbolTable;
    private final Map<Node, SymbolTable> nodeSymbolTableMap;
    private final ClassWriter classWriter;
    private SymbolTable curSymbolTable;
    private MethodVisitor curMethodVisitor;
    private String curOwnerClass = "";

    public Generate(AnalyseContext analyseContext, Map<Node, SymbolTable> nodeSymbolTableMap, ClassWriter classWriter) {
        this.globalSymbolTable = analyseContext.getGlobalSymbolTable();
        this.nodeSymbolTableMap = nodeSymbolTableMap;
        this.classWriter = classWriter;
    }

    public void genInit(ClassWriter classWriter) {
        MethodVisitor methodVisitor = classWriter.visitMethod(
                Opcodes.ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null
        );
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                "java/lang/Object",
                "<init>",
                "()V",
                false
        );
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();
    }

    public void genStaticInit(ClassWriter classWriter, List<VariableDecl> variableDeclList) {
        MethodVisitor methodVisitor = classWriter.visitMethod(
                Opcodes.ACC_STATIC,
                "<clinit>",
                "()V",
                null,
                null
        );
        ExprInsGenerator insGenerator = new ExprInsGenerator(curSymbolTable, methodVisitor, curOwnerClass);
        methodVisitor.visitCode();
        FunctionSymbol functionSymbol = (FunctionSymbol) curSymbolTable.resolve("<clinit>");
        variableDeclList.forEach(variableDecl -> {
            Expr initializer = variableDecl.getInitializer();
            String name = variableDecl.getId().getName();
            Symbol symbol = curSymbolTable.resolve(name);
            if (initializer != null) {
                Type type = insGenerator.visitExpr(initializer);
                insGenerator.genTypePrompt(type, variableDecl.getPromptType());
            } else {
                insGenerator.genDefaultInitializer(symbol.getType());
            }
            methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC, curOwnerClass, name, symbol.getDescriptor());
        });
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(functionSymbol.getStackSize(), 0);
        methodVisitor.visitEnd();
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        String name = node.getQualifiedName();
        curOwnerClass = name;
        classWriter.visit(Opcodes.V1_8,
                Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER,
                name,
                null,
                "java/lang/Object",
                null);

        curSymbolTable = globalSymbolTable.getGlobal();
        genInit(classWriter);

        List<VariableDecl> variableDeclList = new ArrayList<>();
        for (Decl decl : node.getDeclList()) {
            if (decl instanceof VariableDecl) {
                variableDeclList.add((VariableDecl) decl);
            }
        }
        genStaticInit(classWriter, variableDeclList);
        node.getDeclList().forEach(this::visitDecl);
        classWriter.visitEnd();
        return null;
    }

    @Override
    public Void visitFunctionDecl(FunctionDecl node) {
        curSymbolTable = nodeSymbolTableMap.get(node);
        Objects.requireNonNull(curSymbolTable, "Required symbol table for function");
        String name = node.getId().getName();
        FunctionSymbol functionSymbol = (FunctionSymbol) curSymbolTable.resolve(node.getId().getName());
        curMethodVisitor = classWriter.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                name,
                functionSymbol.getDescriptor(),
                null,
                null
        );
        curMethodVisitor.visitCode();
        visitBlockStmt(node.getBody());
        curMethodVisitor.visitMaxs(functionSymbol.getStackSize(), functionSymbol.getLocalSize());
        curMethodVisitor.visitEnd();
        curMethodVisitor = null;
        return null;
    }

    @Override
    public Void visitBlockStmt(BlockStmt node) {
        SymbolTable prevSymbolTable = curSymbolTable;
        curSymbolTable = nodeSymbolTableMap.get(node);
        node.getStmtList().forEach(this::visitStmt);
        curSymbolTable = prevSymbolTable;
        return null;
    }

    @Override
    public Void visitVariableDecl(VariableDecl node) {
        if (node.isTopLevel()) {
            String name = node.getId().getName();
            Symbol symbol = globalSymbolTable.resolveSymbol(name);
            FieldVisitor fieldVisitor = classWriter.visitField(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                    name,
                    symbol.getDescriptor(),
                    null,
                    null
            );
            fieldVisitor.visitEnd();
        } else {
            Symbol symbol = curSymbolTable.resolve(node.getId().getName());
            Expr initializer = node.getInitializer();
            ExprInsGenerator insGenerator = new ExprInsGenerator(curSymbolTable, curMethodVisitor, curOwnerClass);
            if (initializer == null) {
                insGenerator.genDefaultInitializer(symbol.getType());
            } else {
                Type type = insGenerator.visitExpr(initializer);
                if (node.getPromptType() != null) {
                    curMethodVisitor.visitInsn(TypeUtils.getCastCode(type, node.getPromptType()));
                }
            }
            int op = TypeUtils.getStoreVarCode(symbol.getType());
            curMethodVisitor.visitVarInsn(op, symbol.getOffset());
        }
        return null;
    }
}
