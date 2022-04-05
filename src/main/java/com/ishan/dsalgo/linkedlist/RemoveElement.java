package com.ishan.dsalgo.linkedlist;

/*
Given the head of a linked list and an integer val,
 remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class RemoveElement {

  public ListNode removeElements(ListNode head, int val) {
    ListNode temp = new ListNode(-1);
    temp.next = head;

    ListNode parent = temp;
    ListNode current = head;
    while (current != null) {
      if (current.val == val) {
        parent.next = current.next;
      } else {
        parent = current;
      }
      current = current.next;
    }
    return temp.next;
  }

  public static void main(String[] args) {
    ListNode n71 = new ListNode(7);
    ListNode n72 = new ListNode(7);
    ListNode n73 = new ListNode(7);
    ListNode n74 = new ListNode(7);

    n71.next = n72;
    n72.next = n73;
    n73.next = n74;

    System.out.println(new RemoveElement().removeElements(n71, 7));
  }

}
