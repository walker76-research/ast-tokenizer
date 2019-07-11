package handlers.declaration;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.InitializerDeclaration;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;

public class InitializerDeclarationHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        InitializerDeclaration initializerDeclaration = (InitializerDeclaration) node;
        boolean isStatic = initializerDeclaration.isStatic();
        if(isStatic){
            tokens.add("STATIC");
        }
        Node body = initializerDeclaration.getBody();
        BaseHandler handler = HandlerFactory.getHandler(body);
        if(handler != null) {
            tokens.addAll(handler.handle(body));
        } else {
            System.out.println(body.getClass().getSimpleName());
        }

        return tokens;
    }
}