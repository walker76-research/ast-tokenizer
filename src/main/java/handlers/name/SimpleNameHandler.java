package handlers.name;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleNameHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        Optional<Node> parent = node.getParentNode();
        String parentName = parent.get().getClass().getSimpleName();
        switch (parentName){
            case "ClassOrInterfaceDeclaration": tokens.add(new BCEToken("CLASS_NAME", node)); break;
            case "EnumDeclaration": tokens.add(new BCEToken("ENUM_NAME", node)); break;
            case "NameExpr":
            case "VariableDeclarator": tokens.add(new BCEToken("VARIABLE_NAME", node)); break;
            case "ConstructorDeclaration": tokens.add(new BCEToken("CONSTRUCTOR", node)); break;
            case "Parameter": tokens.add(new BCEToken("PARAMETER_NAME", node)); break;
            case "FieldAccessExpr": tokens.add(new BCEToken("FIELD_NAME", node)); break;
            case "MethodDeclaration": tokens.add(new BCEToken("METHOD_NAME", node)); break;
            case "MethodCallExpr": tokens.add(new BCEToken("METHOD_CALL", node)); break;
            case "TypeParameter": tokens.add(new BCEToken("GENERICS_NAME", node)); break;
            case "ContinueStmt": tokens.add(new BCEToken("CONTINUE_NAME", node)); break;
            case "LabeledStmt": tokens.add(new BCEToken("LABEL_NAME", node)); break;
            default:
                System.err.println("SimpleNameHandler - " + parentName);
                System.exit(-1);
        }
        return tokens;
    }
}