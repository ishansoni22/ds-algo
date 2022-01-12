package com.ishan.dsalgo.queue;

public class LinkedListQueue<T> {

  private Node<T> front = null;
  private Node<T> rear = null;

  public LinkedListQueue() {
  }

  public boolean isEmpty() {
    return front == null;
  }

  public void enqueue(T item) {
    Node<T> newNode = new Node<>(item, null);
    if (isEmpty()) {
      front = newNode;
      rear = newNode;
    } else {
      rear.setNext(newNode);
      rear = newNode;
    }
  }

  public T deque() {
    T item = null;
    if (!isEmpty()) {
      item = front.getData();
      front = front.getNext();
      if (front == rear) {
        rear = null;
      }
    }
    return item;
  }

  public static void main(String[] args) {
    LinkedListQueue<Integer> q = new LinkedListQueue<>();
    q.enqueue(0);
    q.enqueue(5);
    q.deque();
    q.deque();
    System.out.println(q);
  }

}
