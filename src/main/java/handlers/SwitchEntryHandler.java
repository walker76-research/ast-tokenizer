package handlers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchEntry;

import java.util.ArrayList;
import java.util.List;

public class SwitchEntryHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        SwitchEntry switchEntry = (SwitchEntry)node;

        NodeList<Expression> labels = switchEntry.getLabels();
        tokens.add("CASE");
        for (Node child : labels) {
            BaseHandler handler = HandlerFactory.getHandler(child);
            if (handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }

        NodeList<Statement> statements = switchEntry.getStatements();
        tokens.add("DO");
        for (Node child : statements) {
            BaseHandler handler = HandlerFactory.getHandler(child);
            if (handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }

        return tokens;
    }
}
