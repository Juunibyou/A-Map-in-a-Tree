package org.example;

public class Node {
    public KeyValue data;
    public Node left, right;

    public Node(KeyValue data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
