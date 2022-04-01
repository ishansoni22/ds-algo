package com.ishan.dsalgo.trees;

/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
If such a node does not exist, return null.
 */
public class SearchBST {

  public TreeNode searchBST(TreeNode root, int val) {
    return s(root, val);
  }

  private TreeNode s(TreeNode root, int val) {
    if (root == null) {
      return null;
    } else if (root.val == val) {
      return root;
    } else if (root.val < val) {
      return s(root.right, val);
    } else {
      return s(root.left, val);
    }
  }

}
