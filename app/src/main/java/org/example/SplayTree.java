package org.example;

public class SplayTree {

    private Node rotateRight(Node x){
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    private Node rotateLeft(Node x){
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private Node splay(Node root, String key){
        if (root == null || root.data.compareTo(key) == 0){return root;}

        if (key.compareTo(root.data) < 0){
            if(root.left == null) {return root;}

            //left-left
            if (key.compareTo(root.left.data) < 0){
                root.left.left = splay(root.left.left, key);
                root = rotateRight(root);
            }

            //left-right
            else if (key.compareTo(root.left.data) > 0){
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null){
                    root.left = rotateLeft(root.left);
                }
            }

            return  (root.left == null) ? root : rotateRight(root);
        }

        else{
            if(root.right == null){return root;}

            //right-left

            //right-right
        }

    }

    public void insert(T key){

    }

    public T find(T key){

    }

    public void delete(T key){

    }
}
