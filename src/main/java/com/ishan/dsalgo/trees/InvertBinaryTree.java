package com.ishan.dsalgo.trees;

/*
Given the root of a binary tree, invert the tree, and return its root.

https://leetcode.com/problems/invert-binary-tree/

 */
public class InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    return i(root);
  }

  private TreeNode i(TreeNode root) {
    if (root == null) {
      return null;
    }

    //Save references since you are overriding below!
    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = i(right);
    root.right = i(left);

    return root;
  }

}
