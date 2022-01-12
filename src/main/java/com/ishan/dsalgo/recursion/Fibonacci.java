package com.ishan.dsalgo.recursion;

public class Fibonacci {

  private int n;

  public Fibonacci(int n) {
    this.n = n;
  }

  public int calculate() {
    return fibonacci(n);
  }

  private int fibonacci(int i) {
    if (i == 1) {
      return 0;
    } else if (i == 2) {
      return 1;
    }

    return fibonacci(i - 1) + fibonacci(i - 2);
  }

  //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci(10);
    System.out.println(fibonacci.calculate());
  }
}
