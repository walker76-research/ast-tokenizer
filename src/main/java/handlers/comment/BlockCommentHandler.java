package handlers.comment;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;

public class BlockCommentHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        return new ArrayList<>();
    }
}