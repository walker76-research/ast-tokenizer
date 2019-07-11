package utils;

import com.github.javaparser.ast.Node;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    public static List<Node> extractNodes(Node root, Class c){
        List<Node> nodes = new ArrayList<>();

        for(Node child : root.getChildNodes()){
            if(child.getClass().getSimpleName().equals(c.getSimpleName())){
                nodes.add(child);
            }
        }
        return nodes;
    }
}
