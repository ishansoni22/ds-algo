package com.ishan.dsalgo.trees;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapExample {

  public static void main(String[] args) {
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    treeMap.put(10, "Ishan");
    treeMap.put(5, "Mr.");
    treeMap.put(15, "Soni");
    treeMap.put(20, "Random");

    //Returns the value corresponding to this if present, else null
    treeMap.remove(20);

    //treeMap.containsKey();
    //treeMap.containsValue();

    for (Entry<Integer, String> entry : treeMap.entrySet()) {
      System.out.println(entry);
    }

    System.out.println(treeMap.higherKey(7));
    System.out.println(treeMap.higherEntry(7).getValue());

    //All functions that we studied for TreeSet are present and have two variants
    //...key() -> Returns just the key
    //...Entry() -> Returns the Entry Object which you can use to get the value

  }

}
