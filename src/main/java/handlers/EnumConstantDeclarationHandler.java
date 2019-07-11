package handlers;

import com.github.javaparser.ast.Node;

import java.util.ArrayList;
import java.util.List;

public class EnumConstantDeclarationHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("ENUM_CONSTANT");
        return tokens;
    }
}