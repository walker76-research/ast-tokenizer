package handlers.type;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.type.PrimitiveType;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypeHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("PT_" + ((PrimitiveType) node).getType());
        return tokens;
    }
}