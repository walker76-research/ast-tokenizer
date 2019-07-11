package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MethodCallExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        MethodCallExpr expr = (MethodCallExpr)node;
        Optional<Expression> scopeOpt = expr.getScope();
        if(scopeOpt.isPresent()) {
            Node scope = scopeOpt.get();
            BaseHandler handler = HandlerFactory.getHandler(scope);
            if (handler != null) {
                tokens.addAll(handler.handle(scope));
            } else {
                System.out.println(scope.getClass().getSimpleName());
            }
        }

        BaseHandler handler = HandlerFactory.getHandler(expr.getName());
        if (handler != null) {
            tokens.addAll(handler.handle(expr.getName()));
        } else {
            System.out.println(expr.getName().getClass().getSimpleName());
        }

        for(Node n : expr.getArguments()){
            tokens.add("PARAMETER");
        }
        return tokens;
    }
}