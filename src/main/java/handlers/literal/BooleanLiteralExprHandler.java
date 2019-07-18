package handlers.literal;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import handlers.BaseHandler;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class BooleanLiteralExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        String literal = ((BooleanLiteralExpr) node).getValue() ? "TRUE" : "FALSE";
        tokens.add(new BCEToken("BL_" + literal, node));
        return tokens;
    }
}