package handlers;

import com.github.javaparser.ast.Node;

import java.util.ArrayList;
import java.util.List;

public class LineCommentHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        return new ArrayList<>();
    }
}