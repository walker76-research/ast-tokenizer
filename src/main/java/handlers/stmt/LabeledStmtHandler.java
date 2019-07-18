package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.LabeledStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class LabeledStmtHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        LabeledStmt labeledStmt = (LabeledStmt)node;
        Node statement = labeledStmt.getStatement();
        BaseHandler handler = HandlerFactory.getHandler(statement);
        if(handler != null) {
            tokens.addAll(handler.handle(statement));
        } else {
            System.out.println(statement.getClass().getSimpleName());
        }
        return tokens;
    }
}