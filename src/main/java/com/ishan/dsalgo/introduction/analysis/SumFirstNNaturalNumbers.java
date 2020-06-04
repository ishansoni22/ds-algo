package com.ishan.dsalgo.introduction.analysis;

public class SumFirstNNaturalNumbers {

  public int calculate(int n) {
    if(n < 1) {
      throw new IllegalArgumentException("n cannot be less than 1");
    }
    int sum = 0;
    for(int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum;
  }



}
