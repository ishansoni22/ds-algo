package com.ishan.dsalgo.queue;

import java.lang.reflect.Array;

public class Queue<T> {

  private T[] queue;
  int front = 0;
  int size = 0;
  int capacity;

  public Queue(Class<T> tClass, int capacity) {
    queue = (T[]) Array.newInstance(tClass, capacity);
    this.capacity = capacity;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private int getRear() {
    return (front + size - 1) % capacity;
  }

  public void enqueue(T item) {
    if (!isFull()) {
      int rear = getRear();
      rear = (rear + 1) % capacity;
      queue[rear] = item;
      ++size;
    } else {
      System.out.println("Queue is Full. Skipping...");
    }
  }

  public T deque() {
    T item = null;
    if (isEmpty()) {
      System.out.println("Queue is Empty. Skipping");
    } else {
      item = queue[front];
      front = (front + 1) % capacity;
      --size;
    }
    return item;
  }

  /*
  How to iterate over a circular array
   */
  @Override
  public String toString() {
    if (isEmpty()) {
      return null;
    }
    int idx = front;
    int rear = getRear();
    StringBuilder q = new StringBuilder();
    while (idx != rear) {
      q.append(queue[idx]).append(" ");
      idx = (idx + 1) % capacity;
    }
    q.append(queue[rear]);
    return q.toString();
  }

  public static void main(String[] args) {
    Queue<Integer> q1 = new Queue(Integer.class, 4);
    q1.enqueue(0);
    q1.enqueue(1);
    q1.enqueue(2);
    q1.enqueue(3);
    q1.enqueue(4);
    q1.deque();
    q1.deque();
    q1.enqueue(4);
    System.out.println(q1);
  }

}
