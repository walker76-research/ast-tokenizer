package models;

import com.github.javaparser.ast.Node;

public class BCEToken {

    private String tokenValue;
    private Node node;

    private BCEToken() {

    }

    public BCEToken(String tokenValue, Node node) {
        this.tokenValue = tokenValue;
        this.node = node;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
