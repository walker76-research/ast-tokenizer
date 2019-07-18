package handlers.misc;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.CatchClause;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import models.BCEToken;

import java.util.ArrayList;
import java.util.List;

public class CatchClauseHandler extends BaseHandler {
    @Override
    public List<BCEToken> handle(Node node) {
        List<BCEToken> tokens = new ArrayList<>();
        CatchClause catchClause = (CatchClause)node;
        tokens.add(new BCEToken("CATCH", node));

        Node parameter = catchClause.getParameter();
        BaseHandler handler = HandlerFactory.getHandler(parameter);
        if(handler != null) {
            tokens.addAll(handler.handle(parameter));
        } else {
            System.out.println(parameter.getClass().getSimpleName());
        }

        Node body = catchClause.getParameter();
        handler = HandlerFactory.getHandler(body);
        if(handler != null) {
            tokens.addAll(handler.handle(body));
        } else {
            System.out.println(body.getClass().getSimpleName());
        }

        return tokens;
    }
}