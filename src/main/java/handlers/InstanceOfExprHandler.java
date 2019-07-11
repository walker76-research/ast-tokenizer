package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.InstanceOfExpr;

import java.util.ArrayList;
import java.util.List;

public class InstanceOfExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        InstanceOfExpr instanceOfExpr = (InstanceOfExpr) node;

        Node expression = instanceOfExpr.getExpression();
        BaseHandler handler = HandlerFactory.getHandler(expression);
        if (handler != null) {
            tokens.addAll(handler.handle(expression));
        } else {
            System.out.println(expression.getClass().getSimpleName());
        }

        tokens.add("INSTANCEOF");

        Node type = instanceOfExpr.getExpression();
        handler = HandlerFactory.getHandler(type);
        if (handler != null) {
            tokens.addAll(handler.handle(type));
        } else {
            System.out.println(type.getClass().getSimpleName());
        }

        return tokens;
    }
}
