package com.ishan.dsalgo.linkedlist;

/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode lastDistinctNode = head;
    ListNode current = head.next;

    while (current != null) {
      if (lastDistinctNode.val == current.val) {
        lastDistinctNode.next = current.next;
        current = lastDistinctNode.next;
      } else {
        lastDistinctNode = current;
        current = current.next;
      }
    }
    return head;
  }

}
