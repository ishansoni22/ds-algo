package com.ishan.dsalgo.recursion;

public class Factorial {

  int f;

  Factorial(int f) {
    this.f = f;
  }

  int calculate() {
    return calculateIt(1, f);
  }

  /*//Not tail recursive
  private int calculateIt(int f) {
    if (f <= 1) {
      return 1;
    }
    return f * calculateIt(f - 1);
  }*/

  private int calculateIt(int prevProd, int f) {
    if (f <= 1) {
      return prevProd;
    }
    return calculateIt(prevProd * f, f - 1);
  }

  public static void main(String[] args) {
    Factorial f = new Factorial(6);
    System.out.println(f.calculate());
  }

}
