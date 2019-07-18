package handlers.declaration;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.InitializerDeclaration;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class InitializerDeclarationHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        InitializerDeclaration initializerDeclaration = (InitializerDeclaration) node;
        boolean isStatic = initializerDeclaration.isStatic();
        if(isStatic){
            tokens.add(new BCEToken("STATIC", node));
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