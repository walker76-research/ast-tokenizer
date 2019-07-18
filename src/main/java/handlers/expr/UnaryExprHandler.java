package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.UnaryExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class UnaryExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        UnaryExpr expr = (UnaryExpr)node;
        tokens.add(new BCEToken(expr.getOperator().toString(), node));
        for(Node child : node.getChildNodes()){
            BaseHandler handler = HandlerFactory.getHandler(child);
            if(handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }
        return tokens;
    }
}