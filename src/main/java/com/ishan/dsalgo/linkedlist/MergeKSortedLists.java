package com.ishan.dsalgo.linkedlist;

import java.util.PriorityQueue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []

 */
public class MergeKSortedLists {

  public ListNode mergeKLists(
      ListNode[] lists) {
    ListNode temp = new ListNode();
    ListNode current = temp;
    PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));

    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        heap.offer(lists[i]);
      }
    }

    while (!heap.isEmpty()) {
      ListNode node = heap.poll();
      current.next = node;
      current = node;
      if (node.next != null) {
        heap.offer(node.next);
      }
    }
    return temp.next;
  }

}
