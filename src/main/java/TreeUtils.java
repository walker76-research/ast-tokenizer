import com.github.javaparser.ast.Node;

import java.util.*;

class TreeUtils {

    static List<Node> extractNodes(Node root, Class c){
        List<Node> nodes = new ArrayList<>();

        for(Node child : root.getChildNodes()){
            if(child.getClass().getSimpleName().equals(c.getSimpleName())){
                nodes.add(child);
            }
        }
        return nodes;
    }
}
