package handlers.expr;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class AssignExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        BaseHandler handler = HandlerFactory.getHandler(node.getChildNodes().get(0));
        if(handler != null) {
            tokens.addAll(handler.handle(node.getChildNodes().get(0)));
        } else {
            System.out.println(node.getChildNodes().get(0).getClass().getSimpleName());
        }
        tokens.add(new BCEToken("OPERATOR_ASSIGNMENT", node));
        handler = HandlerFactory.getHandler(node.getChildNodes().get(1));
        if(handler != null) {
            tokens.addAll(handler.handle(node.getChildNodes().get(1)));
        } else {
            System.out.println(node.getChildNodes().get(1).getClass().getSimpleName());
        }
        return tokens;
    }
}