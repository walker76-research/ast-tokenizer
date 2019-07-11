package handlers.expr;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NormalAnnotationExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        Optional<Node> parent = node.getParentNode();
        String parentName = parent.get().getClass().getSimpleName();
        switch (parentName){
            case "ClassOrInterfaceDeclaration": tokens.add("CLASS_ANNOTATION"); break;
            case "MethodDeclaration": tokens.add("METHOD_ANNOTATION"); break;
            case "Parameter": tokens.add("PARAMETER_ANNOTATION"); break;
            case "ArrayInitializerExpr": tokens.add("ARRAY_ANNOTATION"); break;
            case "VariableDeclarationExpr": tokens.add("VARIABLE_ANNOTATION"); break;
            case "NormalAnnotationExpr": tokens.add("ANNOTATION"); break;
            case "FieldDeclaration": tokens.add("FIELD_ANNOTATION"); break;
            default:
                System.err.println(node.getClass().getSimpleName());
                System.exit(-1);
        }
        return tokens;
    }
}