package com.ishan.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class BinaryTree<T> {

  private Node<T> root;

  public BinaryTree() {
  }

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  public void inorderTraversal() {
    inorder(this.root);
  }

  private void inorder(Node<T> root) {
    if (Objects.nonNull(root)) {
      inorder(root.getLeft());
      System.out.println(root.getData());
      inorder(root.getRight());
    }
  }

  public void preorderTraversal() {
    preorder(this.root);
  }

  private void preorder(Node<T> root) {
    if (Objects.nonNull(root)) {
      System.out.println(root.getData());
      preorder(root.getLeft());
      preorder(root.getRight());
    }
  }

  public void postorderTraversal() {
    postorder(this.root);
  }

  private void postorder(Node<T> root) {
    if (Objects.nonNull(root)) {
      postorder(root.getLeft());
      postorder(root.getRight());
      System.out.println(root.getData());
    }
  }

  public int height() {
    return h(this.root);
  }

  private int h(Node<T> root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    return Math.max(
        h(root.getLeft()),
        h(root.getRight())
    ) + 1;
  }

  public void levelOrderTraversal() {
    if (Objects.nonNull(this.root)) {
      Deque<Node<T>> queue = new ArrayDeque<>();
      queue.offer(this.root);

      while (!queue.isEmpty()) {
        Node<T> node = queue.poll();
        System.out.println(node.getData());

        if (Objects.nonNull(node.getLeft())) {
          queue.offer(node.getLeft());
        }
        if (Objects.nonNull(node.getRight())) {
          queue.offer(node.getRight());
        }
      }
    }
  }

  public void levelOrderTraversalByLine() {
    if (Objects.nonNull(this.root)) {
      Deque<Node<T>> queue = new ArrayDeque<>();
      queue.offer(this.root);

      while (!queue.isEmpty()) {
        int count = queue.size();
        for (int i = 0; i < count; i++) {
          Node<T> node = queue.poll();
          System.out.print(node.getData() + " ");
          if (Objects.nonNull(node.getLeft())) {
            queue.offer(node.getLeft());
          }
          if (Objects.nonNull(node.getRight())) {
            queue.offer(node.getRight());
          }
        }
        System.out.println();
      }
    }
  }

  public int getSize() {
    return s(this.root);
  }

  private int s(Node<T> root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    return 1 + s(root.getLeft()) + s(root.getRight());
  }

  public static void main(String[] args) {
    Node<Integer> leftlclc = new Node<>(1, null, null);
    Node<Integer> leftlc = new Node<>(0, leftlclc, null);
    Node<Integer> leftrc = new Node<>(7, null, null);
    Node<Integer> left = new Node<>(5, leftlc, leftrc);
    Node<Integer> rightlc = new Node<>(25, null, null);
    Node<Integer> rightrc = new Node<>(40, null, null);
    Node<Integer> right = new Node<>(30, rightlc, rightrc);
    Node<Integer> root = new Node<>(10, left, right);
    BinaryTree<Integer> tree = new BinaryTree<>(root);
    System.out.println(tree.getSize());
  }

}
