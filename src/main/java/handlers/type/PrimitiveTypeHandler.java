package handlers.type;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.type.PrimitiveType;
import handlers.BaseHandler;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypeHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        tokens.add(new BCEToken("PT_" + ((PrimitiveType) node).getType(), node));
        return tokens;
    }
}