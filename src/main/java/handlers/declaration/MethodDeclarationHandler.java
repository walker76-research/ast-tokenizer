package handlers.declaration;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MethodDeclarationHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        MethodDeclaration declaration = (MethodDeclaration)node;

        for(Node n : declaration.getAnnotations()){
            BaseHandler handler = HandlerFactory.getHandler(n);
            if(handler != null) {
                tokens.addAll(handler.handle(n));
            } else {
                System.out.println(n.getClass().getSimpleName());
            }
        }

        for(Node n : declaration.getModifiers()){
            BaseHandler handler = HandlerFactory.getHandler(n);
            if(handler != null) {
                tokens.addAll(handler.handle(n));
            } else {
                System.out.println(n.getClass().getSimpleName());
            }
        }

        tokens.add("METHOD_NAME");

        for(Node n : declaration.getParameters()){
            BaseHandler handler = HandlerFactory.getHandler(n);
            if(handler != null) {
                tokens.addAll(handler.handle(n));
            } else {
                System.out.println(n.getClass().getSimpleName());
            }
        }

        for(Node n : declaration.getThrownExceptions()){
            BaseHandler handler = HandlerFactory.getHandler(n);
            if(handler != null) {
                tokens.addAll(handler.handle(n));
            } else {
                System.out.println(n.getClass().getSimpleName());
            }
        }

        Optional<BlockStmt> bodyOpt = declaration.getBody();
        if(bodyOpt.isPresent()) {
            BaseHandler handler = HandlerFactory.getHandler(bodyOpt.get());
            if (handler != null) {
                tokens.addAll(handler.handle(bodyOpt.get()));
            } else {
                System.out.println(bodyOpt.get().getClass().getSimpleName());
            }
        }

        return tokens;
    }
}