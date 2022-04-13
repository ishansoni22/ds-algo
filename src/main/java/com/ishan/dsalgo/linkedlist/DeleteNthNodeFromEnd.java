package com.ishan.dsalgo.linkedlist;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]

 */
public class DeleteNthNodeFromEnd {

  //See sketch for explanation!
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(-1);

    start.next = head;
    ListNode fast = start;
    ListNode slow = start;

    for (int i = 1; i <= n; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return start.next;
  }

  public ListNode removeNthFromEndNaive(ListNode head, int n) {
    //Find the length of the linked list
    int size = 1;
    ListNode current = head;

    while (current.next != null) {
      ++size;
      current = current.next;
    }

    int toDelete = size - n + 1;

    //If size is 1, return an empty Linked List
    if (size == 1) {
      return null;
    } else if (toDelete == 1) { //Delete Head? - return the second node
      return head.next;
    }

    //Else find the previous node and set it's next to next of the node we need to delete
    ListNode previous = head;
    for (int i = 1; i < toDelete - 1; i++) {
      previous = previous.next;
    }

    previous.next = previous.next.next;

    return head;
  }

}
