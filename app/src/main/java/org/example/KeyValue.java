package org.example;

public class KeyValue implements Comparable<KeyValue>{
    private String key;
    private String value;

    public KeyValue(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {return key;}

    public String getValue() {return value;}
    
    public void setValue(String value){this.value = value;} //the necesity of this

    @Override
    public int compareTo(KeyValue other){
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "(" + key + "," + value + ")";
    }
}
