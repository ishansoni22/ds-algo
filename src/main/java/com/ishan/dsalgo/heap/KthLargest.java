package com.ishan.dsalgo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 */
public class KthLargest {

  /*
  Create min heap of k+1 items
  while adding, if the number of items become greater than k, poll the last item
   - Essentially your heap should have only k items. Peek - This is the kth largest item

   Example 4, 6, 2, 1, k = 2
   1. Heap - 4
   2. Heap - 4, 6
   3. Heap - 2, 4, 6 (Remove 2)
   4. Heap - 1, 4, 6 (Remove 1)
   5. Heap - 4, 6 (Peek, ans = 4)

   */
  public int findKthLargestMinHeap(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(k + 1);

    for (int i = 0; i < nums.length; i++) {
      q.add(nums[i]);
      if (q.size() > k) {
        q.poll();
      }
    }
    return q.peek();
  }

  /*
  Create a max heap and poll k times
   */
  public int findKthLargestMaxHeap(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i : nums) {
      q.add(i);
    }
    int poll = 1;
    int elem = 0;
    while (poll <= k) {
      elem = q.poll();
      ++poll;
    }
    return elem;
  }

  public static void main(String[] args) {
    KthLargest k = new KthLargest();
    System.out.println(k.findKthLargestMinHeap(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }

}
