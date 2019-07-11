package handlers.stmt;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;

public class ContinueStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("CONTINUE");
        return tokens;
    }
}