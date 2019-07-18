package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.SynchronizedStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedStmtHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        tokens.add(new BCEToken("SYNCHRONIZED", node));
        SynchronizedStmt synchronizedStmt = (SynchronizedStmt)node;

        Node expression = synchronizedStmt.getExpression();
        BaseHandler handler = HandlerFactory.getHandler(expression);
        if(handler != null) {
            tokens.addAll(handler.handle(expression));
        } else {
            System.out.println(expression.getClass().getSimpleName());
        }
        Node body = synchronizedStmt.getBody();
        handler = HandlerFactory.getHandler(body);
        if(handler != null) {
            tokens.addAll(handler.handle(body));
        } else {
            System.out.println(body.getClass().getSimpleName());
        }

        return tokens;
    }
}
