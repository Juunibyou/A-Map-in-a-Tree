package org.example;

public class App {
    public static void main(String[] args) {
    TreeMap map = new TreeMap();
 
    // Insert a number of key-value pairs into the tree map
    map.insert("keyOne", "valueOne");
    map.insert("keyTwo", "valueTwo");
    map.insert("keyThree", "valueThree");
    map.insert("keyFour", "valueFour");
    map.insert("keyFive", "valueFive");
 
    // Prints out valueOne
    System.out.println(map.get("keyOne"));
 
    // Prints out valueThree
    System.out.println(map.get("keyThree"));

    System.out.println(map.get("keyFour"));
    System.out.println(map.get("keyFive"));
 
    // Prints out an empty string or some default value of your choice
    System.out.println(map.get("keyDoesNotExist"));
 
    // Deletes the key-value pair from the tree map
    map.delete("keyOne");
    System.out.println(map.get("keyOne"));

    map.delete("keyFour");
    System.out.println(map.get("keyFour"));
  }
}