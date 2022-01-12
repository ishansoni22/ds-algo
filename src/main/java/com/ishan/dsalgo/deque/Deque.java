package com.ishan.dsalgo.deque;

import java.lang.reflect.Array;

public class Deque<T> {

  private T[] q;
  private int capacity;
  private int size = 0;
  private int front = 0;

  public Deque(Class<T> tClass, int capacity) {
    q = (T[]) Array.newInstance(tClass, capacity);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return (front + size - 1) % capacity;
  }

  public boolean insertRear(T item) {
    boolean inserted = false;
    if (!isFull()) {
      int rear = getRear();
      rear = (rear + 1) % capacity;
      q[rear] = item;
      ++size;
      inserted = true;
    }
    return inserted;
  }

  public T deleteFront() {
    T item = null;
    if (!isEmpty()) {
      item = q[front];
      q[front] = null;
      front = (front + 1) % capacity;
      --size;
    }
    return item;
  }

  public boolean insertFront(T item) {
    boolean inserted = false;
    if (!isFull()) {
      front = (front - 1 + capacity) % capacity;
      q[front] = item;
      ++size;
      inserted = true;
    }
    return inserted;
  }

  public T deleteRear() {
    T item = null;
    if (!isEmpty()) {
      int rear = getRear();
      rear = (rear - 1 + capacity) % capacity;
      item = q[rear];
      --size;
    }
    return item;
  }

}
