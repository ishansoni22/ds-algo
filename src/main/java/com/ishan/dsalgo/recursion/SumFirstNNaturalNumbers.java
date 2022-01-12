package com.ishan.dsalgo.recursion;

public class SumFirstNNaturalNumbers {

  private int n;

  public SumFirstNNaturalNumbers(int n) {
    this.n = n;
  }

  public int calculate() {
    return sum(n);
  }

  private int sum(int i) {
    if (i <= 1) {
      return i;
    }
    return i + sum(i - 1);
  }

  //1+2+3+4+5+6+7+8+9+10
  public static void main(String[] args) {
    int n = 2;
    SumFirstNNaturalNumbers sumFirstNNaturalNumbers = new SumFirstNNaturalNumbers(n);
    System.out.println("Expected: " + (n * (n + 1)) / 2);
    System.out.println(sumFirstNNaturalNumbers.calculate());
  }

}
