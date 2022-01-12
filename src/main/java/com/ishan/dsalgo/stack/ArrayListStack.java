package com.ishan.dsalgo.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack<T> {

  private List<T> stack = new ArrayList<>();

  public void push(T item) {
    stack.add(item);
  }

  public T pop() {
    return stack.remove(stack.size() - 1);
  }

  public T peek() {
    return stack.get(stack.size() - 1);
  }

  public int size() {
    return stack.size();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public static void main(String[] args) {

  }

}
