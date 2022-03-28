package com.ishan.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricalTree {

  public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int levelNodes = q.size();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i <= levelNodes - 1; i++) {
        TreeNode node = q.poll();
        if (Objects.nonNull(node.left)) {
          q.offer(node.left);
          sb.append(node.left.val).append(" ");
        } else {
          sb.append("* ");
        }

        sb.append(node.val).append(" ");

        if (Objects.nonNull(node.right)) {
          q.offer(node.right);
          sb.append(node.right.val).append(" ");
        } else {
          sb.append("* ");
        }
      }
      if (!isSymmetric(sb.toString())) {
        return false;
      }
    }
    return true;
  }

  private boolean isSymmetric(String level) {
    String[] arr = level.split(" ");
    for (int i = 0; i <= arr.length / 2; i++) {
      if (!arr[i].equals(arr[arr.length - i - 1])) {
        return false;
      }
    }
    return true;
  }

}
