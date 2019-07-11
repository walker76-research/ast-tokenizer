package handlers;

import com.github.javaparser.ast.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassOrInterfaceTypeHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        Optional<Node> parent = node.getParentNode();
        String parentName = parent.get().getClass().getSimpleName();
        switch (parentName){
            case "VariableDeclarator": tokens.add("VARIABLE_TYPE"); break;
            case "Parameter": tokens.add("PARAMETER_TYPE"); break;
            case "ObjectCreationExpr": tokens.add("OBJECT"); break;
            case "MethodDeclaration": tokens.add("RETURN_TYPE"); break;
            case "MethodCallExpr":
            case "ClassOrInterfaceDeclaration":
            case "ClassExpr": tokens.add("CLASS_TYPE"); break;
            case "CastExpr": tokens.add("CAST_TYPE"); break;
            case "ArrayType":
            case "ArrayCreationExpr": tokens.add("ARRAY_TYPE"); break;
            case "ConstructorDeclaration": tokens.add("SUPERCLASS_TYPE"); break;
            default:
                System.err.println("ClassOrInterfaceTypeHandler - " + parentName);
                System.exit(-1);
        }
        return tokens;
    }
}