package net.ziyoung.lox.ast;

import net.ziyoung.lox.ast.stmt.Decl;

import java.util.List;
import java.util.Map;

public class CompilationUnit extends Node {
    private final String packageName;
    private final List<Decl> declList;

    public CompilationUnit(String packageName, List<Decl> declList) {
        this.packageName = packageName;
        this.declList = declList;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<Decl> getDeclList() {
        return declList;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCompilationUnit(this);
    }

    @Override
    public Map<String, String> getProperties() {
        return updateNodeKind("CompilationUnit");
    }
}
