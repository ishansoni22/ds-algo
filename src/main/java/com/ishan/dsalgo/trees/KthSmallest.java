package com.ishan.dsalgo.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class KthSmallest {

  //Todo - Approach 3

  /*
  O(n) -> but requires O(n) extra space
   */
  public int kthSmallestArray(TreeNode root, int k) {
    List<Integer> elements = new ArrayList<>();
    kSmallestArray(root, elements);
    return elements.get(k - 1);
  }

  private void kSmallestArray(TreeNode node, List<Integer> elements) {
    if (Objects.nonNull(node)) {
      kSmallestArray(node.left, elements);
      elements.add(node.val);
      kSmallestArray(node.right, elements);
    }
  }

  /*
  O(nlogn) -> Not optimal
   */
  public int kthSmallestMaxHeap(TreeNode root, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(k + 1, Comparator.reverseOrder());
    kSmallestMaxHeap(root, q, k);
    return q.peek();
  }

  private void kSmallestMaxHeap(TreeNode node, PriorityQueue<Integer> q, int k) {
    if (!Objects.isNull(node)) {
      kSmallestMaxHeap(node.left, q, k);
      q.add(node.val);
      if (q.size() > k) {
        q.poll();
      }
      kSmallestMaxHeap(node.right, q, k);
    }
  }

  public static void main(String[] args) {

  }

}
