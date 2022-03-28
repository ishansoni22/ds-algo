package com.ishan.dsalgo.hashing;

/*
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

    void add(key) Inserts the value key into the HashSet.
    bool contains(key) Returns whether the value key exists in the HashSet or not.
    void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)

Constraints:

    0 <= key <= 10pow(6)
    At most 10pow(4) calls will be made to add, remove, and contains.

 */

/*
Simple Solution
 public class MyHashSet {

  private boolean[] bucket = new boolean[1000000];

  public MyHashSet() {
  }

  public void add(int key) {
    bucket[key] = true;
  }

  public void remove(int key) {
    bucket[key] = false;
  }

  public boolean contains(int key) {
    return bucket[key] == true;
  }

}*/

import java.util.TreeSet;

public class MyHashSet {

  private static final int BUCKET_SIZE = 7919;

  //You could have used a Linked List Instead
  private TreeSet<Integer>[] bucket = new TreeSet[BUCKET_SIZE];

  public MyHashSet() {
  }

  public void add(int key) {
    int addr = key % BUCKET_SIZE;
    if (bucket[addr] == null) {
      TreeSet<Integer> ts = new TreeSet<>();
      ts.add(key);
      bucket[addr] = ts;
    } else {
      bucket[addr].add(key);
    }
  }

  public void remove(int key) {
    int addr = key % BUCKET_SIZE;
    if (bucket[addr] != null) {
      bucket[addr].remove(key);
    }
  }

  public boolean contains(int key) {
    int addr = key % BUCKET_SIZE;
    if (bucket[addr] != null) {
      return bucket[addr].contains(key);
    }
    return false;
  }

}
