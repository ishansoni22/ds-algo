package com.ishan.dsalgo.arrays;

import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

    KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
    int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8

 */
class KthLargestStream {

  private int k;
  private PriorityQueue<Integer> q;

  public KthLargestStream(int k, int[] nums) {
    this.k = k;
    this.q = new PriorityQueue<>(k + 1);
    for (int n : nums) {
      q.offer(n);
      if (q.size() > k) {
        q.poll();
      }
    }
  }

  public int add(int val) {
    q.offer(val);
    if (q.size() > k) {
      q.poll();
    }
    return q.peek();
  }

  public static void main(String[] args) {
    KthLargestStream k = new KthLargestStream(3, new int[]{5, 4, 8, 3});
    System.out.println(k.add(4));
    System.out.println(k.add(5));
    System.out.println(k.add(5));
    System.out.println(k.add(8));
    System.out.println(k.add(8));
  }

}