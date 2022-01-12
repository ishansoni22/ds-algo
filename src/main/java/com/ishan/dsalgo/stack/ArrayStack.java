package com.ishan.dsalgo.stack;

import java.lang.reflect.Array;

public class ArrayStack<T> {

  private T[] stack;
  private int top;

  /*
  Create a generic array in Java
   */
  public ArrayStack(Class<T> tClass, int capacity) {
    stack = (T[]) Array.newInstance(tClass, capacity);
    top = -1;
  }

  /*
  Let Array's index out of bounds mimic the overflow exception!
   */
  public void push(T item) {
    ++top;
    stack[top] = item;
  }

  /*
  Let Array's index of bounds mimic the underflow exception
   */
  public T pop() {
    T item = stack[top];
    stack[top] = null;
    --top;
    return item;
  }

  public T peek() {
    return stack[top];
  }

  public int size() {
    return top + 1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public static void main(String[] args) {
    ArrayStack<Integer> stack = new ArrayStack<>(Integer.class, 10);
    stack.push(0);
    stack.push(5);

    System.out.println(stack.pop());
  }

}
