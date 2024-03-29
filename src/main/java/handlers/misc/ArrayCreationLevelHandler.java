package handlers.misc;

import com.github.javaparser.ast.Node;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class ArrayCreationLevelHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();

        tokens.add(new BCEToken("[", node));
        for(Node child : node.getChildNodes()){
            BaseHandler handler = HandlerFactory.getHandler(child);
            if(handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }
        tokens.add(new BCEToken("]", node));

        return tokens;
    }
}