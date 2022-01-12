package com.ishan.dsalgo.linkedlist;

class DoublyNode<T> {

  private T data;
  private DoublyNode<T> next;
  private DoublyNode<T> previous;

  DoublyNode(T data, DoublyNode<T> next, DoublyNode<T> previous) {
    this.data = data;
    this.next = next;
    this.previous = previous;
  }

  T getData() {
    return data;
  }

  void setData(T data) {
    this.data = data;
  }

  DoublyNode<T> getNext() {
    return next;
  }

  void setNext(DoublyNode<T> next) {
    this.next = next;
  }

  DoublyNode<T> getPrevious() {
    return previous;
  }

  void setPrevious(DoublyNode<T> previous) {
    this.previous = previous;
  }

  @Override
  public String toString() {
    return this.data.toString();
  }

}
