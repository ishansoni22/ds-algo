package com.ishan.dsalgo.trees;

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTrees {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    return t(p, q);
  }

  private boolean t(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if ((p == null && q != null) || (p != null && q == null)) {
      return false;
    } else if (p.val != q.val) {
      return false;
    }
    return t(p.left, q.left) && t(p.right, q.right);
  }

}
