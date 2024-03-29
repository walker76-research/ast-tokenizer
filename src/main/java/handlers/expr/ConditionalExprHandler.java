package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ConditionalExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class ConditionalExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        ConditionalExpr expr = (ConditionalExpr)node;
        tokens.add(new BCEToken("IF", node));
        BaseHandler handler = HandlerFactory.getHandler(expr.getCondition());
        if(handler != null) {
            tokens.addAll(handler.handle(expr.getCondition()));
        } else {
            System.out.println(expr.getCondition().getClass().getSimpleName());
        }
        tokens.add(new BCEToken("THEN", node));
        handler = HandlerFactory.getHandler(expr.getThenExpr());
        if(handler != null) {
            tokens.addAll(handler.handle(expr.getThenExpr()));
        } else {
            System.out.println(expr.getThenExpr().getClass().getSimpleName());
        }

        if(expr.getElseExpr().getChildNodes().size() > 0)
            tokens.add(new BCEToken("ELSE", node));
        for(Node child : expr.getElseExpr().getChildNodes()){
            handler = HandlerFactory.getHandler(child);
            if(handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }
        return tokens;
    }
}