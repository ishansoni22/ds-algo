package com.ishan.dsalgo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

 */

/*
A cleaner solution is to add 2 pseudo nodes (a pseudo head and a pseudo tail) to prevent all the null checks!
 */
public class LRUCache {

  private int capacity;
  private Node head;
  private Node tail;
  private Map<Integer, Node> mappingTable;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.mappingTable = new HashMap<>();
  }

  public int get(int key) {
    int value = -1;
    if (mappingTable.containsKey(key)) {
      Node node = mappingTable.get(key);
      value = node.value;
      delete(node);
      add(key, value);
    }
    return value;
  }

  public void put(int key, int value) {
    if (mappingTable.containsKey(key)) {
      update(mappingTable.get(key), value);
    } else {
      add(key, value);
    }
  }

  private void delete(Node node) {
    mappingTable.remove(node.key);
    if (node == head && node == tail) {
      head = null;
      tail = null;
    } else if (node == head) {
      node.next.prev = null;
      head = node.next;
    } else if (node == tail) {
      node.prev.next = null;
      tail = node.prev;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
  }

  private void update(Node currentNode, int newValue) {
    delete(currentNode);
    add(currentNode.key, newValue);
  }

  private void add(int key, int value) {
    if (mappingTable.size() == capacity) {
      delete(tail);
    }

    Node node = new Node(key, value);

    if (head == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
    mappingTable.put(key, node);
  }

  private class Node {

    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(1);
    lruCache.put(1, 1);
    lruCache.put(1, 11);
    lruCache.put(2, 2);
    lruCache.put(3, 3);
  }

}
