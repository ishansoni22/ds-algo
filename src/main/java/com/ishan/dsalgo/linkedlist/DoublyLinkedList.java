package com.ishan.dsalgo.linkedlist;

import java.util.Objects;

public class DoublyLinkedList<T> {

  private DoublyNode<T> head = null;

  public DoublyLinkedList() {
  }

  public DoublyLinkedList(T item) {
    this.head = new DoublyNode<>(item, null, null);
  }

  public void addFirst(T item) {
    if (Objects.isNull(this.head)) {
      this.head = new DoublyNode<>(item, null, null);
    } else {
      DoublyNode<T> newNode = new DoublyNode<>(item, this.head, null);
      this.head.setPrevious(newNode);
      this.head = newNode;
    }
  }

  public void addLast(T item) {
    if (Objects.isNull(this.head)) {
      addFirst(item);
    } else {
      DoublyNode<T> iterator = this.head;

      while (Objects.nonNull(iterator.getNext())) {
        iterator = iterator.getNext();
      }
      iterator.setNext(new DoublyNode<>(item, null, iterator));
    }
  }

  public void reverse() {
    DoublyNode<T> iterator = this.head;

    while (Objects.nonNull(iterator)) {
      DoublyNode<T> current = iterator;
      /*
      Save the next node to traverse before we swap!
       */
      iterator = iterator.getNext();

      DoublyNode<T> nextTemp = current.getNext();
      current.setNext(current.getPrevious());
      current.setPrevious(nextTemp);

      /*
      The last node should now be the new HEAD
       */
      if (iterator == null) {
        this.head = current;
      }
    }
  }

  public void removeFirst() {
    if (Objects.isNull(this.head)) {
      throw new RuntimeException("Linked List is already empty");
    } else if (Objects.isNull(this.head.getNext())) {
      this.head = null;
    } else {
      this.head = this.head.getNext();
      this.head.setPrevious(null);
    }
  }

  public void removeLast() {
    if (Objects.isNull(this.head)) {
      throw new RuntimeException("Linked List is already empty");
    } else if (Objects.isNull(this.head.getNext())) {
      removeFirst();
    } else {
      DoublyNode<T> iterator = this.head;
      /*
      Reach the node which you want to delete
       */
      while (Objects.nonNull(iterator.getNext())) {
        iterator = iterator.getNext();
      }
      iterator.getPrevious().setNext(null);
      iterator.setPrevious(null);
    }
  }

  @Override
  public String toString() {
    DoublyNode<T> iterator = this.head;
    StringBuilder chain = new StringBuilder();
    while (Objects.nonNull(iterator)) {
      chain.append(iterator.toString()).append("->");
      iterator = iterator.getNext();
    }
    return chain.append("NULL").toString();
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> ll = new DoublyLinkedList<>(5);
    ll.addFirst(0);
    ll.addLast(10);
    System.out.println(ll);
    ll.reverse();
    System.out.println(ll);
  }

}
