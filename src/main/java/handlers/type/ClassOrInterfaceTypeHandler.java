package handlers.type;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassOrInterfaceTypeHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        Optional<Node> parent = node.getParentNode();
        String parentName = parent.get().getClass().getSimpleName();
        switch (parentName){
            case "VariableDeclarator": tokens.add(new BCEToken("VARIABLE_TYPE", node)); break;
            case "Parameter": tokens.add(new BCEToken("PARAMETER_TYPE", node)); break;
            case "ObjectCreationExpr": tokens.add(new BCEToken("OBJECT", node)); break;
            case "MethodDeclaration": tokens.add(new BCEToken("RETURN_TYPE", node)); break;
            case "MethodCallExpr":
            case "ClassOrInterfaceDeclaration":
            case "ClassExpr": tokens.add(new BCEToken("CLASS_TYPE", node)); break;
            case "CastExpr": tokens.add(new BCEToken("CAST_TYPE", node)); break;
            case "ArrayType":
            case "ArrayCreationExpr": tokens.add(new BCEToken("ARRAY_TYPE", node)); break;
            case "ConstructorDeclaration": tokens.add(new BCEToken("SUPERCLASS_TYPE", node)); break;
            default:
                System.err.println("ClassOrInterfaceTypeHandler - " + parentName);
                System.exit(-1);
        }
        return tokens;
    }
}