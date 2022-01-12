package com.ishan.dsalgo.linkedlist;

import java.util.Objects;

public class LinkedList<T> {

  private Node<T> head = null;

  public LinkedList() {
  }

  public LinkedList(T item) {
    this.head = new Node<>(item, null);
  }

  public void addFirst(T item) {
    this.head = new Node<>(item, this.head);
  }

  public void addLast(T item) {
    if (Objects.isNull(this.head)) {
      addFirst(item);
    } else {
      Node<T> iterator = this.head;
      while (Objects.nonNull(iterator.getNext())) {
        iterator = iterator.getNext();
      }
      iterator.setNext(new Node<>(item, null));
    }
  }

  public void addAt(int position, T item) {
    if (Objects.isNull(this.head) || position <= 1) {
      addFirst(item);
    } else {
      int current = 1;
      int searchIdx = position - 1;
      Node<T> iterator = this.head;
      while (current < searchIdx && Objects.nonNull(iterator.getNext())) {
        iterator = iterator.getNext();
      }
      iterator.setNext(new Node<>(item, iterator.getNext()));
    }
  }

  public void removeFirst() {
    if (Objects.isNull(this.head)) {
      throw new RuntimeException("List is already Empty");
    }
    this.head = this.head.getNext();
  }

  public void removeLast() {
    if (Objects.isNull(this.head)) {
      throw new RuntimeException("List is already Empty");
    } else if (Objects.isNull(this.head.getNext())) {
      removeFirst();
    } else {
      Node<T> iterator = this.head;
      while (Objects.nonNull(iterator.getNext().getNext())) {
        iterator = iterator.getNext();
      }
      iterator.setNext(null);
    }
  }

  public int search(T item) {
    Node<T> iterator = this.head;
    int idx = 1;
    while (Objects.nonNull(iterator)) {
      if (item.equals(iterator.getData())) {
        return idx;
      }
      iterator = iterator.getNext();
      ++idx;
    }
    return -1;
  }

  @Override
  public String toString() {
    Node<T> iterator = this.head;
    StringBuilder chain = new StringBuilder();
    while (Objects.nonNull(iterator)) {
      chain.append(iterator.toString()).append("->");
      iterator = iterator.getNext();
    }
    return chain.append("NULL").toString();
  }

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>(5);
    ll.addFirst(0);
    ll.addLast(15);
    System.out.println(ll);
    ll.removeFirst();
    System.out.println(ll);
    ll.removeLast();
    System.out.println(ll);
    ll.addAt(1, 0);
    ll.addAt(5, 10);
    System.out.println(ll);
    System.out.print(ll.search(10));
  }

}
