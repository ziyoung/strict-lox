package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class SemanticError {
    private final Position position;
    private final String msg;

    public SemanticError(Position position, String msg) {
        this.position = position;
        this.msg = msg;
    }

    @Override
    public String toString() {
        String string = position != null ? position.toString() : "";
        return string + " " + msg;
    }
}

public class SemanticErrorList {
    private List<SemanticError> errorList = new ArrayList<>();

    public void add(Position position, String msg) {
        errorList.add(new SemanticError(position, msg));
    }

    public void reset() {
        errorList = new ArrayList<>();
    }

    public int size() {
        return errorList.size();
    }

    public Stream<String> stream() {
        return errorList.stream().map(SemanticError::toString);
    }
//    @Override
//    public String toString() {
//        if (errorList.size() == 0) {
//            return "";
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        errorList.forEach(semanticError -> stringBuilder
//                .append(semanticError.toString())
//                .append("\n")
//        );
//        return stringBuilder.toString();
//    }
}
