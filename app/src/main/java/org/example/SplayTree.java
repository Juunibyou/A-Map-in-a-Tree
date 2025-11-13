package org.example;

public class SplayTree {
    private Node root;

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

    public Node splay(Node root, KeyValue key){
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
            if (root.right == null){return root;}

            //right-left
            if (key.compareTo(root.right.data) < 0){
                root.right.left = splay(root.right.left, key);

                if (root.right.left != null){
                    root.right = rotateRight(root.right);
                }
            }

            //right-right
            else if (key.compareTo(root.right.data) > 0){
                root.right.right = splay(root.right.right, key);
                root = rotateLeft(root);
            }

            return(root.right == null) ? root : rotateLeft(root);
        }

    }

    public void insert(KeyValue keyvalue){

        if (root == null) {
            root = new Node(keyvalue);
            return;
        }

        root  = splay(root,keyvalue);

        int compared = keyvalue.compareTo(root.data);

        if (compared == 0) {
            root.data.setValue(keyvalue.getValue());
            return;
        }

        Node newNode = new Node(keyvalue);
        if (compared < 0) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }

        root = newNode;
    }

    public KeyValue find(String key){
        KeyValue keyvalue = new KeyValue(key, "");
        root = splay(root, keyvalue);

        if(root != null && root.data.getKey().equals(key)){
            return root.data;
        }

        return null;
    }

    public void delete(String key){
        if (root == null) {return;}

        KeyValue keyvalue = new KeyValue(key, "");
        root = splay(root.keyvalue);

        if (!root.data.getKey().equals(key)) {return;}

        if (root.left == null){
            root = root.right;
        } else {
            Node temp = root.right;
            root = root.left;
            root = splay(root, keyvalue);
            root.right = temp;
        }
    }
}
