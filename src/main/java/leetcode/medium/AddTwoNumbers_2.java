package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    Deque<Integer> valueStack = new ArrayDeque<>();
    ListNode currentNode = this;
    do {
      valueStack.push(currentNode.val);
      currentNode = currentNode.next;
    } while (Objects.nonNull(currentNode));

    StringBuilder builder = new StringBuilder();
    while (!valueStack.isEmpty()) {
      builder.append(valueStack.pop());
    }
    return builder.toString();
  }

}

public class AddTwoNumbers_2 {

  public ListNode add(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode head = null;
    ListNode last = null;

    while (l1 != null || l2 != null || carry != 0) {
      if (l1 != null) {
        carry += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        carry += l2.val;
        l2 = l2.next;
      }
      ListNode temp = new ListNode(carry % 10);
      if (head == null) {
        head = temp;
        last = head;
      } else {
        last.next = temp;
        last = temp;
      }
      carry = carry / 10;

    }
    return head;
  }

  public static void main(String[] args) {
    AddTwoNumbers_2 obj = new AddTwoNumbers_2();

    //[1,9,9,9,9,9,9,9,9,9]
    ListNode l11 = new ListNode(9);
    ListNode l12 = new ListNode(9, l11);
    ListNode l13 = new ListNode(9, l12);
    ListNode l14 = new ListNode(9, l13);
    ListNode l15 = new ListNode(9, l14);
    ListNode l16 = new ListNode(9, l15);
    ListNode l17 = new ListNode(9, l16);
    ListNode l18 = new ListNode(9, l17);
    ListNode l19 = new ListNode(9, l18);
    ListNode l20 = new ListNode(1, l19);

    ListNode r11 = new ListNode(9);

    ListNode sum = obj.add(l20, r11);

    System.out.println(sum);
  }

  /***
   Won't work for large lists!
   public ListNode addObsolete(ListNode l1, ListNode l2) {
   Long sum = getNumber(l1) + getNumber(l2);
   ListNode last = null;
   for (char c : String.valueOf(sum)
   .toCharArray()) {
   ListNode node = new ListNode(Character.getNumericValue(c), last);
   last = node;
   }
   return last;
   }

   private Long getNumber(ListNode node) {
   Deque<Integer> valueStack = new ArrayDeque<>();
   ListNode currentNode = node;
   do {
   valueStack.push(currentNode.getVal());
   currentNode = currentNode.getNext();
   } while (Objects.nonNull(currentNode));

   StringBuilder builder = new StringBuilder();
   while (!valueStack.isEmpty()) {
   builder.append(valueStack.pop());
   }
   return Long.valueOf(builder.toString());
   }
   */

}