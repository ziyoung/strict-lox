package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.AstBaseVisitor;
import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.ast.Expr;
import net.ziyoung.lox.ast.Node;
import net.ziyoung.lox.ast.stmt.FunctionDecl;
import net.ziyoung.lox.ast.stmt.VariableDecl;
import net.ziyoung.lox.phase.visitor.ExprInsGenerator;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import net.ziyoung.lox.symbol.Symbol;
import net.ziyoung.lox.symbol.SymbolTable;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Generate extends AstBaseVisitor<Void> {

    private final GlobalSymbolTable globalSymbolTable;
    private final Map<Node, SymbolTable> nodeSymbolTableMap;
    private final ClassWriter classWriter;
    private SymbolTable curSymbolTable;
    private MethodVisitor curMethodVisitor;

    public Generate(AnalyseContext analyseContext, Map<Node, SymbolTable> nodeSymbolTableMap, ClassWriter classWriter) {
        this.globalSymbolTable = analyseContext.getGlobalSymbolTable();
        this.nodeSymbolTableMap = nodeSymbolTableMap;
        this.classWriter = classWriter;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node) {
        String name = node.getQualifiedName();
        classWriter.visit(Opcodes.V1_8,
                Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER,
                name,
                null,
                "java/lang/Object",
                null);

        curSymbolTable = globalSymbolTable.getGlobal();
        node.getDeclList().forEach(this::visitDecl);

        // TODO: <clinit> ()V
        classWriter.visitEnd();
        return null;
    }

    @Override
    public Void visitFunctionDecl(FunctionDecl node) {
        curSymbolTable = nodeSymbolTableMap.get(node);
        String name = node.getId().getName();
        Symbol symbol = curSymbolTable.resolve(node.getId().getName());
        curMethodVisitor = classWriter.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                name,
                symbol.getName(),
                null,
                null
        );
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
            ExprInsGenerator insGenerator = new ExprInsGenerator(curSymbolTable, curMethodVisitor);
            if (initializer == null) {
                insGenerator.visitDefaultInitializer(symbol.getType());
            } else {
                insGenerator.visitExpr(initializer);
            }
            curMethodVisitor.visitVarInsn(symbol.getLoadCode(), symbol.getOffset());
        }
        return null;
    }
}
