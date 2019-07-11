package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.IfStmt;

import java.util.ArrayList;
import java.util.List;

public class IfStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        IfStmt expr = (IfStmt)node;
        tokens.add("IF");
        BaseHandler handler = HandlerFactory.getHandler(expr.getCondition());
        if(handler != null) {
            tokens.addAll(handler.handle(expr.getCondition()));
        } else {
            System.out.println(expr.getCondition().getClass().getSimpleName());
        }
        tokens.add("THEN");
        for(Node child : expr.getThenStmt().getChildNodes()){
            handler = HandlerFactory.getHandler(child);
            if(handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }
        if(expr.getElseStmt().isPresent()) {
            tokens.add("ELSE");
            Node elseStmt = expr.getElseStmt().get();
            for (Node child : elseStmt.getChildNodes()) {
                handler = HandlerFactory.getHandler(child);
                if (handler != null) {
                    tokens.addAll(handler.handle(child));
                } else {
                    System.out.println(child.getClass().getSimpleName());
                }
            }
        }
        return tokens;
    }
}