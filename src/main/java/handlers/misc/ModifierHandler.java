package handlers.misc;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;

public class ModifierHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add(((Modifier) node).getKeyword().name());
        return tokens;
    }
}