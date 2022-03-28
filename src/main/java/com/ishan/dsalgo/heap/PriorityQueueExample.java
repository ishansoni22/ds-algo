package com.ishan.dsalgo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

  public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    queue.add(10); //or offer
    queue.add(5);
    queue.add(20);
    queue.add(1);

    System.out.println(queue.peek());
    System.out.println(queue.poll());
    System.out.println(queue.peek());

    //Implement MaxHeap?

    PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.reverseOrder());

  }

}
