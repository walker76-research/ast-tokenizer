package handlers.name;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;

public class NameHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        String parent = node.getParentNode().getClass().getSimpleName();
        switch (parent){
            case "MarkerAnnotationExpr": tokens.add("ANNOTATION_NAME"); break;
            case "MethodCallExpr": tokens.add("VARIABLE"); break;
            default:
                System.err.println("NameHandler - " + parent);
                System.exit(-1);
        }
        return tokens;
    }
}