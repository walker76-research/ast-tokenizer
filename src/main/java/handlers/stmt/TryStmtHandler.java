package handlers.stmt;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.TryStmt;
import handlers.BaseHandler;
import handlers.HandlerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TryStmtHandler extends BaseHandler {
    @Override
    public List<String> handle(Node node) {
        List<String> tokens = new ArrayList<>();
        tokens.add("TRY");

        Node tryBlock = ((TryStmt) node).getTryBlock();
        BaseHandler handler = HandlerFactory.getHandler(tryBlock);
        if(handler != null) {
            tokens.addAll(handler.handle(tryBlock));
        } else {
            System.out.println(tryBlock.getClass().getSimpleName());
        }

        for(Node child : ((TryStmt) node).getCatchClauses()){
            handler = HandlerFactory.getHandler(child);
            if(handler != null) {
                tokens.addAll(handler.handle(child));
            } else {
                System.out.println(child.getClass().getSimpleName());
            }
        }

        Optional<BlockStmt> finallyBlockOpt = ((TryStmt) node).getFinallyBlock();
        if(finallyBlockOpt.isPresent()){
            BlockStmt finallyBlock = finallyBlockOpt.get();
            handler = HandlerFactory.getHandler(finallyBlock);
            if(handler != null) {
                tokens.addAll(handler.handle(finallyBlock));
            } else {
                System.out.println(finallyBlock.getClass().getSimpleName());
            }
        }

        return tokens;
    }
}