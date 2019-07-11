package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ArrayCreationExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;

public class ArrayCreationExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();

        tokens.add("NEW");
        ArrayCreationExpr arrayCreationExpr = (ArrayCreationExpr)node;
        Node elementType = arrayCreationExpr.getElementType();
        BaseHandler handler = HandlerFactory.getHandler(elementType);
        if(handler != null) {
            tokens.addAll(handler.handle(elementType));
        } else {
            System.out.println(elementType.getClass().getSimpleName());
        }
        tokens.add("ARRAY");

        for(Node child : arrayCreationExpr.getLevels()){
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