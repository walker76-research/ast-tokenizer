package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.WhileStmt;

import java.util.ArrayList;
import java.util.List;

public class WhileStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        WhileStmt whileStmt = (WhileStmt)node;
        tokens.add("WHILE");
        Node condition = whileStmt.getCondition();
        BaseHandler handler = HandlerFactory.getHandler(condition);
        if(handler != null) {
            tokens.addAll(handler.handle(condition));
        } else {
            System.out.println(condition.getClass().getSimpleName());
        }
        tokens.add("DO");
        Node body = whileStmt.getBody();
        handler = HandlerFactory.getHandler(body);
        if(handler != null) {
            tokens.addAll(handler.handle(body));
        } else {
            System.out.println(body.getClass().getSimpleName());
        }

        return tokens;
    }
}