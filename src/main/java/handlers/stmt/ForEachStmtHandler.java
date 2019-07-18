package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.ForEachStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class ForEachStmtHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        tokens.add(new BCEToken("FOR", node));
        tokens.add(new BCEToken("EACH", node));
        ForEachStmt stmt = (ForEachStmt)node;
        BaseHandler handler = HandlerFactory.getHandler(stmt.getVariable());
        if(handler != null) {
            tokens.addAll(handler.handle(stmt.getVariable()));
        } else {
            System.out.println(stmt.getVariable().getClass().getSimpleName());
        }
        tokens.add(new BCEToken("IN", node));
        handler = HandlerFactory.getHandler(stmt.getIterable());
        if(handler != null) {
            tokens.addAll(handler.handle(stmt.getIterable()));
        } else {
            System.out.println(stmt.getIterable().getClass().getSimpleName());
        }
        tokens.add(new BCEToken("DO", node));
        handler = HandlerFactory.getHandler(stmt.getBody());
        if(handler != null) {
            tokens.addAll(handler.handle(stmt.getBody()));
        } else {
            System.out.println(stmt.getBody().getClass().getSimpleName());
        }
        return tokens;
    }
}