package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.LabeledStmt;

import java.util.ArrayList;
import java.util.List;

public class LabeledStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
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