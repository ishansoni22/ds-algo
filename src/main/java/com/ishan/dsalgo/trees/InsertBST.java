package com.ishan.dsalgo.trees;

/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree.
Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion,
as long as the tree remains a BST after insertion. You can return any of them.

 */
public class InsertBST {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    return i(root, val);
  }

  private TreeNode i(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    } else if (val < root.val) {
      root.left = i(root.left, val);
    } else {
      root.right = i(root.right, val);
    }
    return root;
  }

  //Iterative
  public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
    TreeNode parent = null;
    TreeNode current = root;

    while (current != null) {
      parent = current;
      if (val < current.val) {
        current = current.left;
      } else {
        current = current.right;
      }
    }

    TreeNode node = new TreeNode(val);
    if (parent == null) {
      return node;
    } else {
      if (val < parent.val) {
        parent.left = node;
      } else {
        parent.right = node;
      }
    }
    return root;
  }

}
