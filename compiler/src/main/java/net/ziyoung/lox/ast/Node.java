package net.ziyoung.lox.ast;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Map;

public abstract class Node {
    private Position position;

    public void setPosition(Token startToken) {
        position = new Position(startToken);
    }

    public void setPosition(ParserRuleContext context) {
        setPosition(context.start);
    }

    public void setPosition(TerminalNode node) {
        setPosition(node.getSymbol());
    }

    public Position getPosition() {
        return position;
    }

    @JsonAnyGetter
    public abstract Map<String, String> getProperties();

    public Map<String, String> updateNodeKind(String kind) {
        return Map.of("kind", kind);
    }

    public abstract <R> R accept(AstVisitor<R> visitor);
}
