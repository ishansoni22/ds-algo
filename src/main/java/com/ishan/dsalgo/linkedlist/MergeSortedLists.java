package com.ishan.dsalgo.linkedlist;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class MergeSortedLists {

  public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
    ListNode head = m(new ListNode(-1), list1, list2);
    return head.next;
  }

  private ListNode m(ListNode current, ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      current.next = null;
    } else if (list2 == null) {
      current.next = m(list1, list1.next, null);
    } else if (list1 == null) {
      current.next = m(list2, null, list2.next);
    } else {
      if (list1.val <= list2.val) {
        current.next = m(list1, list1.next, list2);
      } else {
        current.next = m(list2, list1, list2.next);
      }
    }
    return current;
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode(-1);
    ListNode current = head;

    while (list1 != null && list2 != null) {
      ListNode newNode = new ListNode();
      if (list1.val <= list2.val) {
        newNode.val = list1.val;
        list1 = list1.next;
      } else {
        newNode.val = list2.val;
        list2 = list2.next;
      }
      current.next = newNode;
      current = newNode;
    }

    while (list1 != null) {
      ListNode newNode = new ListNode(list1.val);
      list1 = list1.next;
      current.next = newNode;
      current = newNode;
    }

    while (list2 != null) {
      ListNode newNode = new ListNode(list2.val);
      list2 = list2.next;
      current.next = newNode;
      current = newNode;
    }

    return head.next;
  }

}