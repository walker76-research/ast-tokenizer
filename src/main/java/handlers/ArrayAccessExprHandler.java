package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ArrayAccessExpr;

import java.util.ArrayList;
import java.util.List;

public class ArrayAccessExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();

        ArrayAccessExpr arrayAccessExpr = (ArrayAccessExpr) node;
        Node name = arrayAccessExpr.getName();
        Node index = arrayAccessExpr.getIndex();

        BaseHandler handler = HandlerFactory.getHandler(name);
        if(handler != null) {
            tokens.addAll(handler.handle(name));
        } else {
            System.out.println(name.getClass().getSimpleName());
        }

        tokens.add("[");

        handler = HandlerFactory.getHandler(index);
        if(handler != null) {
            tokens.addAll(handler.handle(index));
        } else {
            System.out.println(index.getClass().getSimpleName());
        }

        tokens.add("]");

        return tokens;
    }
}