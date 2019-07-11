package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ConditionalExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;

public class ConditionalExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        ConditionalExpr expr = (ConditionalExpr)node;
        tokens.add("IF");
        BaseHandler handler = HandlerFactory.getHandler(expr.getCondition());
        if(handler != null) {
            tokens.addAll(handler.handle(expr.getCondition()));
        } else {
            System.out.println(expr.getCondition().getClass().getSimpleName());
        }
        tokens.add("THEN");
        handler = HandlerFactory.getHandler(expr.getThenExpr());
        if(handler != null) {
            tokens.addAll(handler.handle(expr.getThenExpr()));
        } else {
            System.out.println(expr.getThenExpr().getClass().getSimpleName());
        }

        if(expr.getElseExpr().getChildNodes().size() > 0)
            tokens.add("ELSE");
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