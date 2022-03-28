package com.ishan.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InorderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> tl = new ArrayList<>();
    traverse(root, tl);
    return tl;
  }

  private void traverse(TreeNode node, List<Integer> tl) {
    if (Objects.nonNull(node)) {
      traverse(node.left, tl);
      tl.add(node.val);
      traverse(node.right, tl);
    }
  }

  public static void main(String[] args) {

  }

}
