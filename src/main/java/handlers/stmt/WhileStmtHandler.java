package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.WhileStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class WhileStmtHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        WhileStmt whileStmt = (WhileStmt)node;
        tokens.add(new BCEToken("WHILE", node));
        Node condition = whileStmt.getCondition();
        BaseHandler handler = HandlerFactory.getHandler(condition);
        if(handler != null) {
            tokens.addAll(handler.handle(condition));
        } else {
            System.out.println(condition.getClass().getSimpleName());
        }
        tokens.add(new BCEToken("DO", node));
        Node body = whileStmt.getBody();
        handler = HandlerFactory.getHandler(body);
        if(handler != null) {
            tokens.addAll(handler.handle(body));
        } else {
            System.out.println(body.getClass().getSimpleName());
        }

        return tokens;
    }
}