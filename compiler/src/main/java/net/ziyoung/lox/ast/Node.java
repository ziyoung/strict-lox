package net.ziyoung.lox.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public abstract class Node {
    private Position start;
    private Position end;

    public void setPosition(Token startToken, Token endToken) {
        start = new Position(startToken);
        end = new Position(endToken);
    }

    public void setPosition(ParserRuleContext context) {
        setPosition(context.start, context.stop);
    }

    public abstract <R> R accept(AstVisitor<R> visitor);
}
