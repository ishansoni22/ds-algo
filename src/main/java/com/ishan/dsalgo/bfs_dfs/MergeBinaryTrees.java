package com.ishan.dsalgo.bfs_dfs;

/*
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]

Example 2:

Input: root1 = [1], root2 = [1,2]
Output: [2,2]

 */
public class MergeBinaryTrees {

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    //return m(root1, root2);
    return mCleaner(root1, root2);
  }

  private TreeNode mCleaner(TreeNode n1, TreeNode n2) {
    if (n1 == null && n2 == null) {
      return null;
    }
    if (n1 == null) {
      return n2;
    }
    if (n2 == null) {
      return n1;
    }

    int value = n1.val + n2.val;
    TreeNode node = new TreeNode(value);

    node.left = mCleaner(n1.left, n2.left);
    node.right = mCleaner(n1.right, n2.right);

    return node;
  }

  private TreeNode m(TreeNode n1, TreeNode n2) {
    if (n1 == null && n2 == null) {
      return null;
    }

    int value = (n1 != null ? n1.val : 0) + (n2 != null ? n2.val : 0);
    TreeNode newNode = new TreeNode(value);

    newNode.left = m(n1 != null ? n1.left : null, n2 != null ? n2.left : null);
    newNode.right = m(n1 != null ? n1.right : null, n2 != null ? n2.right : null);

    return newNode;
  }

}
