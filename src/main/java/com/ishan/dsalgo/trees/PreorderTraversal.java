package com.ishan.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PreorderTraversal {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> tl = new ArrayList<>();
    traverse(root, tl);
    return tl;
  }

  private void traverse(TreeNode node, List<Integer> tl) {
    if (Objects.nonNull(node)) {
      tl.add(node.val);
      traverse(node.left, tl);
      traverse(node.right, tl);
    }
  }

  public static void main(String[] args) {

  }

}
