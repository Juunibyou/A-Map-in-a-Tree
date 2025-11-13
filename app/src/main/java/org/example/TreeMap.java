package org.example;

public class TreeMap {
    private SplayTree tree;

    public TreeMap() {
        tree = new SplayTree();
    }

    public void insert(String key, String value) {
        tree.insert(new KeyValue(key, value));
    }

    public String get(String key) {
        KeyValue keyvalue = tree.find(key);
        return (keyvalue == null) ? "" : keyvalue.getValue();
    }

    public void delete(String key) {
        tree.delete(key);
    }
}
