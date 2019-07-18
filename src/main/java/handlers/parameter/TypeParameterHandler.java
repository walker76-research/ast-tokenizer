package handlers.parameter;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;
import models.BCEToken;

import java.util.List;

public class TypeParameterHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        return delegateToChildren(node);
    }
}