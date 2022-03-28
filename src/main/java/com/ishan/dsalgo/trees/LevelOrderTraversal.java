package com.ishan.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class LevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> tl = new ArrayList<>();
    if (Objects.isNull(root)) {
      return tl;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int levelSize = q.size();
      List<Integer> levelNodes = new ArrayList<>();
      for (int i = 1; i <= levelSize; i++) {
        TreeNode node = q.poll();
        levelNodes.add(node.val);
        if (Objects.nonNull(node.left)) {
          q.offer(node.left);
        }
        if (Objects.nonNull(node.right)) {
          q.offer(node.right);
        }
      }
      tl.add(levelNodes);
    }
    return tl;
  }

}
