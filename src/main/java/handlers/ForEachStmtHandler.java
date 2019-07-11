package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.ForEachStmt;

import java.util.ArrayList;
import java.util.List;

public class ForEachStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("FOR");
        tokens.add("EACH");
        ForEachStmt stmt = (ForEachStmt)node;
        BaseHandler handler = HandlerFactory.getHandler(stmt.getVariable());
        if(handler != null) {
            tokens.addAll(handler.handle(stmt.getVariable()));
        } else {
            System.out.println(stmt.getVariable().getClass().getSimpleName());
        }
        tokens.add("IN");
        handler = HandlerFactory.getHandler(stmt.getIterable());
        if(handler != null) {
            tokens.addAll(handler.handle(stmt.getIterable()));
        } else {
            System.out.println(stmt.getIterable().getClass().getSimpleName());
        }
        tokens.add("DO");
        handler = HandlerFactory.getHandler(stmt.getBody());
        if(handler != null) {
            tokens.addAll(handler.handle(stmt.getBody()));
        } else {
            System.out.println(stmt.getBody().getClass().getSimpleName());
        }
        return tokens;
    }
}