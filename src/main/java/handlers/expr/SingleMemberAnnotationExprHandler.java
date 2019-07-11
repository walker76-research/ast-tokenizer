package handlers.expr;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;

public class SingleMemberAnnotationExprHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("SM_ANNOTATION");
        SingleMemberAnnotationExpr singleMemberAnnotationExpr = (SingleMemberAnnotationExpr)node;
        Node memberValue = singleMemberAnnotationExpr.getMemberValue();
        BaseHandler handler = HandlerFactory.getHandler(memberValue);
        if(handler != null) {
            tokens.addAll(handler.handle(memberValue));
        } else {
            System.out.println(memberValue.getClass().getSimpleName());
        }

        return tokens;
    }
}
