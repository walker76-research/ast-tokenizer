package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.CastExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class CastExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        CastExpr castExpr = (CastExpr) node;
        tokens.add(new BCEToken("CAST", node));
        Node expression = castExpr.getExpression();
        BaseHandler handler = HandlerFactory.getHandler(expression);
        if (handler != null) {
            tokens.addAll(handler.handle(expression));
        } else {
            System.out.println(expression.getClass().getSimpleName());
        }

        tokens.add(new BCEToken("TO", node));
        Node type = castExpr.getType();
        handler = HandlerFactory.getHandler(type);
        if (handler != null) {
            tokens.addAll(handler.handle(type));
        } else {
            System.out.println(type.getClass().getSimpleName());
        }

        return tokens;
    }
}