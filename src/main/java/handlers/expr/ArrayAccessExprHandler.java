package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class ArrayAccessExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();

        ArrayAccessExpr arrayAccessExpr = (ArrayAccessExpr) node;
        Node name = arrayAccessExpr.getName();
        Node index = arrayAccessExpr.getIndex();

        BaseHandler handler = HandlerFactory.getHandler(name);
        if(handler != null) {
            tokens.addAll(handler.handle(name));
        } else {
            System.out.println(name.getClass().getSimpleName());
        }

        tokens.add(new BCEToken("[", node));

        handler = HandlerFactory.getHandler(index);
        if(handler != null) {
            tokens.addAll(handler.handle(index));
        } else {
            System.out.println(index.getClass().getSimpleName());
        }

        tokens.add(new BCEToken("]", node));

        return tokens;
    }
}