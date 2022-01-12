package com.ishan.dsalgo.queue;

class Node<T> {

  private T data;

  private Node<T> next;

  Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return this.data;
  }

  Node<T> getNext() {
    return this.next;
  }

  public void setData(T data) {
    this.data = data;
  }

  void setNext(Node<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return this.data.toString();
  }

}
