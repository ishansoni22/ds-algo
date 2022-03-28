package com.ishan.dsalgo.heap;

import java.lang.reflect.Array;
import java.util.Objects;

public class MinHeap<T extends Comparable> {

  private T[] items;
  private int size;
  private int capacity;

  public MinHeap(Class<T> tClass, int capacity) {
    this.items = (T[]) Array.newInstance(tClass, capacity);
    this.capacity = capacity;
    this.size = 0;
  }

  public MinHeap(T[] a) {
    this.items = a;
    this.capacity = a.length;
    this.size = a.length;

    for (int i = (this.size - 2) / 2; i >= 0; i--) {
      minHeapify(i);
    }
  }

  private boolean isEmpty() {
    return this.size == 0;
  }

  /*
  In real world, you will use dynamic sized arrays
  which will resize themselves!
   */
  private boolean isFull() {
    return this.capacity == this.size;
  }

  private int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int getParent(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private void swap(int i, int j) {
    T temp = this.items[i];
    this.items[i] = this.items[j];
    this.items[j] = temp;
  }

  public void insert(T item) {
    if (isFull()) {
      System.out.println("Heap is Full");
      return;
    } else {
      int insertIdx = this.size;
      this.items[insertIdx] = item;
      ++this.size;

      while (insertIdx != 0) {
        int parentIdx = getParent(insertIdx);
        if (this.items[insertIdx].compareTo(this.items[parentIdx]) < 0) {
          swap(insertIdx, parentIdx);
          insertIdx = parentIdx;
        } else {
          break;
        }
      }
    }
  }

  public T getMinimum() {
    if (isEmpty()) {
      return null;
    }
    return this.items[0];
  }

  public T extractMinimum() {
    T min = getMinimum();
    if (!Objects.isNull(min)) {
      if (this.size == 1) {
        this.items[0] = null;
        --this.size;
      } else {
        this.items[0] = this.items[size - 1];
        this.items[size - 1] = null;
        --size;
        minHeapify(0);
      }
    }
    return min;
  }

  public void minHeapify(int index) {
    int lcIndex = getLeftChildIndex(index);
    int rcIndex = getRightChildIndex(index);
    int smallest = index;

    /*
    If left child exists and is smaller than the current smallest
     */
    if (lcIndex < this.size && this.items[lcIndex].compareTo(this.items[smallest]) < 0) {
      smallest = lcIndex;
    }

    if (rcIndex < this.size && this.items[rcIndex].compareTo(this.items[smallest]) < 0) {
      smallest = rcIndex;
    }

    if (smallest != index) {
      swap(smallest, index);
      minHeapify(smallest);
    }
  }

  public void decreaseKey(int index, T value) {
    if (index > this.size) {
      System.out.println("Out of Bounds...");
      return;
    } else if (this.items[index].compareTo(value) < 0) {
      System.out.println("Given Value Greater than Current Value...");
      return;
    } else {
      this.items[index] = value;
      while (index != 0) {
        int parentIndex = getParent(index);
        if (this.items[index].compareTo(this.items[parentIndex]) < 0) {
          swap(index, parentIndex);
          index = parentIndex;
        } else {
          break;
        }
      }
    }
  }

  public T delete(int index) {
    T minusInfinity = null; //How do you handle the generic case?
    decreaseKey(index, minusInfinity);
    return extractMinimum();
  }

  public static void main(String[] args) {
    MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
    heap.insert(10);
    heap.insert(5);
    heap.insert(20);
    heap.insert(1);
    System.out.println(heap);

    System.out.println(heap.getMinimum());

    System.out.println(heap.extractMinimum());

    System.out.println(heap.getMinimum());
  }

}
