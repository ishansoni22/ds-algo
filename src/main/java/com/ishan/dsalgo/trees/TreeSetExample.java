package com.ishan.dsalgo.trees;

import java.util.TreeSet;

public class TreeSetExample {

  public static void main(String[] args) {
    TreeSet<Integer> treeSet = new TreeSet<>();

    treeSet.add(15);

    treeSet.add(25);

    treeSet.add(20);

    treeSet.add(5);

    treeSet.add(30);

    treeSet.add(10);

    //Gives you the largest value that is lower than this value
    System.out.println(treeSet.lower(27)); //25

    //Gives you the lowest value greater than this value
    System.out.println(treeSet.higher(30)); //null

    //Gives you the largest value that is lower/equal to this value
    System.out.println(treeSet.floor(5));

    //Gives you the smallest value that is greater/equal to this value
    System.out.println(treeSet.ceiling(28));

    //Gives you the lowest key
    System.out.println(treeSet.first()); // 5

    //Gives you the highest key
    System.out.println(treeSet.last()); //30

    //Gives you a set of smaller keys
    System.out.println(treeSet.headSet(10));

    //Gives you a set of larger keys
    System.out.println(treeSet.tailSet(10));

  }

}
