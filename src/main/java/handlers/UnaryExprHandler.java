package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.UnaryExpr;

import java.util.ArrayList;
import java.util.List;

public class UnaryExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        UnaryExpr expr = (UnaryExpr)node;
        tokens.add(expr.getOperator().toString());
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