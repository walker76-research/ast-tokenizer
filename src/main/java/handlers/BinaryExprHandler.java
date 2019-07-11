package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.BinaryExpr;

import java.util.ArrayList;
import java.util.List;

public class BinaryExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();

        BinaryExpr expr = (BinaryExpr)node;
        BaseHandler handler = HandlerFactory.getHandler(expr.getLeft());
        if(handler != null) {
            tokens.addAll(handler.handle(expr.getLeft()));
        } else {
            System.out.println(expr.getLeft().getClass().getSimpleName());
        }

        tokens.add(expr.getOperator().asString());

        handler = HandlerFactory.getHandler(expr.getRight());
        if(handler != null) {
            tokens.addAll(handler.handle(expr.getRight()));
        } else {
            System.out.println(expr.getRight().getClass().getSimpleName());
        }

        return tokens;
    }
}