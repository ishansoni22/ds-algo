package com.ishan.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> tl = new ArrayList<>();
    traverse(root, tl);
    return tl;
  }

  private void traverse(TreeNode node, List<Integer> tl) {
    if (Objects.nonNull(node)) {
      traverse(node.left, tl);
      traverse(node.right, tl);
      tl.add(node.val);
    }
  }

  public static void main(String[] args) {

  }

}
