package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.DoStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;

public class DoStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("DO");
        DoStmt doStmt = (DoStmt)node;
        Node body = doStmt.getBody();
        BaseHandler handler = HandlerFactory.getHandler(body);
        if(handler != null) {
            tokens.addAll(handler.handle(body));
        } else {
            System.out.println(body.getClass().getSimpleName());
        }
        tokens.add("WHILE");
        Node condition = doStmt.getCondition();
        handler = HandlerFactory.getHandler(condition);
        if(handler != null) {
            tokens.addAll(handler.handle(condition));
        } else {
            System.out.println(condition.getClass().getSimpleName());
        }

        return tokens;
    }
}