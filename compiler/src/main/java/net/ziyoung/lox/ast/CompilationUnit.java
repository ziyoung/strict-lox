package net.ziyoung.lox.ast;

import net.ziyoung.lox.ast.stmt.Decl;

import java.util.List;

public class CompilationUnit implements Node {
    private final String packageName;
    private final List<Decl> decls;

    public CompilationUnit(String packageName, List<Decl> decls) {
        this.packageName = packageName;
        this.decls = decls;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<Decl> getDecls() {
        return decls;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCompilationUnit(this);
    }
}
