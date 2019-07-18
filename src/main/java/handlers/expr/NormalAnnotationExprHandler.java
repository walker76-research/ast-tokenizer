package handlers.expr;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NormalAnnotationExprHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        Optional<Node> parent = node.getParentNode();
        String parentName = parent.get().getClass().getSimpleName();
        switch (parentName){
            case "ClassOrInterfaceDeclaration": tokens.add(new BCEToken("CLASS_ANNOTATION", node)); break;
            case "MethodDeclaration": tokens.add(new BCEToken("METHOD_ANNOTATION", node)); break;
            case "Parameter": tokens.add(new BCEToken("PARAMETER_ANNOTATION", node)); break;
            case "ArrayInitializerExpr": tokens.add(new BCEToken("ARRAY_ANNOTATION", node)); break;
            case "VariableDeclarationExpr": tokens.add(new BCEToken("VARIABLE_ANNOTATION", node)); break;
            case "NormalAnnotationExpr": tokens.add(new BCEToken("ANNOTATION", node)); break;
            case "FieldDeclaration": tokens.add(new BCEToken("FIELD_ANNOTATION", node)); break;
            default:
                System.err.println(node.getClass().getSimpleName());
                System.exit(-1);
        }
        return tokens;
    }
}