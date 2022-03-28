package com.ishan.dsalgo.hashing;

import java.util.TreeMap;

public class MyHashMap {

  private static final int BUCKET_SIZE = 7919;

  private TreeMap<Integer, Integer>[] bucket = new TreeMap[BUCKET_SIZE];

  public MyHashMap() {
  }

  public void put(int key, int value) {
    int addr = key % BUCKET_SIZE;
    if (bucket[addr] == null) {
      TreeMap<Integer, Integer> m = new TreeMap<>();
      m.put(key, value);
      bucket[addr] = m;
    } else {
      bucket[addr].put(key, value);
    }
  }

  public void remove(int key) {
    int addr = key % BUCKET_SIZE;
    if (bucket[addr] != null) {
      bucket[addr].remove(key);
    }
  }

  public int get(int key) {
    int addr = key % BUCKET_SIZE;
    if (bucket[addr] != null && bucket[addr].containsKey(key)) {
      return bucket[addr].get(key);
    }
    return -1;
  }

}
