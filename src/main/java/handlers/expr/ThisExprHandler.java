package handlers.expr;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;

public class ThisExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("THIS");
        return tokens;
    }
}