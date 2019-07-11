package handlers.name;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleNameHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        Optional<Node> parent = node.getParentNode();
        String parentName = parent.get().getClass().getSimpleName();
        switch (parentName){
            case "ClassOrInterfaceDeclaration": tokens.add("CLASS_NAME"); break;
            case "EnumDeclaration": tokens.add("ENUM_NAME"); break;
            case "NameExpr":
            case "VariableDeclarator": tokens.add("VARIABLE_NAME"); break;
            case "ConstructorDeclaration": tokens.add("CONSTRUCTOR"); break;
            case "Parameter": tokens.add("PARAMETER_NAME"); break;
            case "FieldAccessExpr": tokens.add("FIELD_NAME"); break;
            case "MethodDeclaration": tokens.add("METHOD_NAME"); break;
            case "MethodCallExpr": tokens.add("METHOD_CALL"); break;
            case "TypeParameter": tokens.add("GENERICS_NAME"); break;
            case "ContinueStmt": tokens.add("CONTINUE_NAME"); break;
            case "LabeledStmt": tokens.add("LABEL_NAME"); break;
            default:
                System.err.println("SimpleNameHandler - " + parentName);
                System.exit(-1);
        }
        return tokens;
    }
}