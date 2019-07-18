package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class ArrayInitializerExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        tokens.add(new BCEToken("{", node));
        ArrayInitializerExpr arrayInitializerExpr = (ArrayInitializerExpr)node;

        for (Node child : arrayInitializerExpr.getValues()) {
            BaseHandler handler = HandlerFactory.getHandler(child);
            if (handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }
        tokens.add(new BCEToken("}", node));

        return tokens;
    }
}