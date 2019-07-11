package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;

import java.util.ArrayList;
import java.util.List;

public class BooleanLiteralExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        String literal = ((BooleanLiteralExpr) node).getValue() ? "TRUE" : "FALSE";
        tokens.add("BL_" + literal);
        return tokens;
    }
}