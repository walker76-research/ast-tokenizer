package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.SwitchStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;

public class SwitchStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("SWITCH");
        SwitchStmt switchStmt = (SwitchStmt)node;
        Node selector = switchStmt.getSelector();
        BaseHandler handler = HandlerFactory.getHandler(selector);
        if (handler != null) {
            tokens.addAll(handler.handle(selector));
        } else {
            System.out.println(selector.getClass().getSimpleName());
        }

        for (Node child : switchStmt.getEntries()) {
            handler = HandlerFactory.getHandler(child);
            if (handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }

        return tokens;
    }
}