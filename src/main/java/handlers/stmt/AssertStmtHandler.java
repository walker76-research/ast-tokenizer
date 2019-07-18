package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.AssertStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class AssertStmtHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        tokens.add(new BCEToken("ASSERT", node));
        AssertStmt assertStmt = (AssertStmt)node;
        Node check = assertStmt.getCheck();
        BaseHandler handler = HandlerFactory.getHandler(check);
        if(handler != null) {
            tokens.addAll(handler.handle(check));
        } else {
            System.out.println(check.getClass().getSimpleName());
        }

        return tokens;
    }
}
