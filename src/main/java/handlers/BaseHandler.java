package handlers;

import com.github.javaparser.ast.Node;

import java.util.List;

public abstract class BaseHandler {

    public abstract List<String> handle(Node node);
}
