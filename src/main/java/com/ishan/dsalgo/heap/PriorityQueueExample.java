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

    //Duplicate Test
    System.out.println("Duplicate Test");
    PriorityQueue<Integer> dq = new PriorityQueue<>();
    dq.offer(1);
    dq.offer(1);

    System.out.println(dq.size());
    System.out.println(dq.poll());
    System.out.println(dq.poll());

    //Initial Capacity
    PriorityQueue<Integer> s = new PriorityQueue<>(2, Comparator.reverseOrder());
    s.offer(1);
    s.offer(2);
    s.offer(3);

    System.out.println(s.size());
    System.out.println(s.poll());
    System.out.println(s.poll());
    System.out.println(s.poll());
  }

}
