package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.AssertStmt;

import java.util.ArrayList;
import java.util.List;

public class AssertStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("ASSERT");
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
