package com.ishan.dsalgo.trees;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 */
public class ValidateBST {

  public boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValid(TreeNode root, long minValue, long maxValue) {
    if (root == null) {
      return true;
    }

    if (!(root.val > minValue && root.val < maxValue)) {
      return false;
    }

    return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    TreeNode n4 = new TreeNode(4);
    TreeNode n6 = new TreeNode(6);
    TreeNode n3 = new TreeNode(3);
    TreeNode n7 = new TreeNode(7);

    root.left = n4;
    root.right = n6;

    n6.left = n3;
    n6.right = n7;

    ValidateBST vbst = new ValidateBST();
    System.out.println(vbst.isValidBST(root));
  }

}
