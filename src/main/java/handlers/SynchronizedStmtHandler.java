package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.SynchronizedStmt;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("SYNCHRONIZED");
        SynchronizedStmt synchronizedStmt = (SynchronizedStmt)node;

        Node expression = synchronizedStmt.getExpression();
        BaseHandler handler = HandlerFactory.getHandler(expression);
        if(handler != null) {
            tokens.addAll(handler.handle(expression));
        } else {
            System.out.println(expression.getClass().getSimpleName());
        }
        Node body = synchronizedStmt.getBody();
        handler = HandlerFactory.getHandler(body);
        if(handler != null) {
            tokens.addAll(handler.handle(body));
        } else {
            System.out.println(body.getClass().getSimpleName());
        }

        return tokens;
    }
}
