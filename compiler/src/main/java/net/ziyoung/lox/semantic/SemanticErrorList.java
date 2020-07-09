package net.ziyoung.lox.semantic;

import net.ziyoung.lox.ast.Position;

import java.util.ArrayList;

public class SemanticErrorList extends ArrayList<SemanticError> {

    public void add(Position position, String msg) {
        this.add(new SemanticError(position, msg));
    }

}
