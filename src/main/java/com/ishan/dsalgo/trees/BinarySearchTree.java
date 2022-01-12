package com.ishan.dsalgo.trees;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable> {

  private Node<T> root;

  public BinarySearchTree() {
  }

  public BinarySearchTree(Node<T> root) {
    this.root = root;
  }

  //Insert

  public void insert(T item) {
    Node<T> node = new Node<>(item, null, null);
    Node<T> curr = this.root;
    Node<T> parent = null;

    while (Objects.nonNull(curr)) {
      parent = curr;
      if (item.compareTo(curr.getData()) == 0) {
        break;
      } else if (item.compareTo(curr.getData()) < 0) {
        curr = curr.getLeft();
      } else {
        curr = curr.getRight();
      }
    }

    if (Objects.isNull(parent)) {
      this.root = node;
    } else if (item.compareTo(parent.getData()) == 0) {
      //Do nothing. Item is already present
    } else if (item.compareTo(parent.getData()) < 0) {
      parent.setLeft(node);
    } else {
      parent.setRight(node);
    }
  }

  //Delete

  public void delete() {

  }

  public boolean contains(T key) {
    return c(this.root, key);
  }

  private boolean c(Node<T> root, T key) {
    if (Objects.isNull(root)) {
      return false;
    } else if (key.equals(root.getData())) {
      return true;
    } else if (key.compareTo(root.getData()) < 0) {
      return c(root.getLeft(), key);
    } else {
      return c(root.getRight(), key);
    }
  }

  public static void main(String[] args) {
    //Node<Integer> leftlclc = new Node<>(1, null, null);
    //Node<Integer> leftlc = new Node<>(3, leftlclc, null);
    //Node<Integer> leftrc = new Node<>(7, null, null);
    //Node<Integer> left = new Node<>(5, leftlc, leftrc);
    //Node<Integer> rightlc = new Node<>(25, null, null);
    //Node<Integer> rightrc = new Node<>(40, null, null);
    //Node<Integer> right = new Node<>(30, rightlc, rightrc);
    //Node<Integer> root = new Node<>(10, left, right);

    BinarySearchTree<Integer> t = new BinarySearchTree<>();
    t.insert(10);
    t.insert(30);
    t.insert(5);
    t.insert(7);
    t.insert(3);
    t.insert(1);
    t.insert(4);
  }

}
