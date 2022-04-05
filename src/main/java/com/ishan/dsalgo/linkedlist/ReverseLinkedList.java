package com.ishan.dsalgo.linkedlist;

import java.util.ArrayDeque;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode first = head;
    ListNode second = head.next;
    head.next = null;

    while (second != null) {
      ListNode newSecond = second.next;
      second.next = first;
      first = second;
      second = newSecond;
    }

    return first;
  }

  public ListNode reverseListNaive(ListNode head) {
    if (head == null) {
      return null;
    }

    ArrayDeque<ListNode> stack = new ArrayDeque<>();
    ListNode current = head;

    while (current != null) {
      stack.push(current);
      current = current.next;
    }

    head = new ListNode(-1);
    current = head;

    while (!stack.isEmpty()) {
      ListNode node = stack.pop();
      current.next = node;
      current = node;
    }

    current.next = null;

    return head.next;
  }

}
