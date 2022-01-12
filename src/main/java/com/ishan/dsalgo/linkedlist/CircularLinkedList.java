package com.ishan.dsalgo.linkedlist;

import java.util.Objects;

public class CircularLinkedList<T> {

  private Node<T> tail;

  public CircularLinkedList() {
  }

  public CircularLinkedList(T item) {
    Node<T> newNode = new Node<>(item, null);
    this.tail = newNode;
    newNode.setNext(this.tail);
  }

  /*
  How to do it in O(1) with just HEAD?
  Create a new node
  Insert it after HEAD
  Interchange HEAD and new node's content!
   */
  public void addFirst(T item) {
    if (Objects.isNull(this.tail)) {
      Node<T> newNode = new Node<>(item, null);
      this.tail = newNode;
      newNode.setNext(this.tail);
    } else {
      Node<T> newNode = new Node<>(item, this.tail.getNext());
      this.tail.setNext(newNode);
    }
  }

  /*
  How to do it in O(1) with just HEAD?
  Create a new node
  Insert it after HEAD
  Interchange HEAD and new node's content
  Point HEAD to the new node!
   */
  public void addLast(T item) {
    if (Objects.isNull(this.tail)) {
      addFirst(item);
    } else {
      Node<T> newNode = new Node<>(item, this.tail.getNext());
      this.tail.setNext(newNode);
      this.tail = newNode;
    }
  }

  //Todo - How to do it in O(1) with just HEAD?
  public void removeFirst() {
    if (Objects.isNull(this.tail)) {
      throw new RuntimeException("Linked List is already empty");
    } else if (Objects.isNull(this.tail.getNext())) {
      this.tail = null;
    } else {
      this.tail.setNext(this.tail.getNext().getNext());
    }
  }

  @Override
  public String toString() {
    if (Objects.isNull(this.tail)) {
      return "";
    }
    StringBuilder chain = new StringBuilder();
    Node<T> iterator = this.tail.getNext();

    while (iterator != this.tail) {
      chain.append(iterator.toString()).append("->");
      iterator = iterator.getNext();
    }

    return chain.append(this.tail.toString()).toString();
  }

  public static void main(String[] args) {
    CircularLinkedList<Integer> ll = new CircularLinkedList<>(5);
    ll.addFirst(0);
    ll.addLast(10);
    ll.removeFirst();
    System.out.println(ll);
  }

}
