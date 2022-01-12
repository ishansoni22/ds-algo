package com.ishan.dsalgo.introduction.analysis;

public class SumFirstNNaturalNumbers {

  public long calculate1(long n) {
    if (n < 1) {
      throw new IllegalArgumentException("n cannot be less than 1");
    }
    long startTime = System.nanoTime();

    long sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += i;
    }

    long endTime = System.nanoTime();
    System.out.println("Time Taken in ms: " + (endTime - startTime) / 1000000);
    return sum;
  }

  public long calculate2(long n) {
    if (n < 1) {
      throw new IllegalArgumentException("n cannot be less than 1");
    }
    long startTime = System.nanoTime();

    long sum = n * (n + 1) / 2;

    long endTime = System.nanoTime();
    System.out.println("Time Taken in ms: " + (endTime - startTime) / 1000000);
    return sum;
  }

  public long calculate3(long n) {
    if (n < 1) {
      throw new IllegalArgumentException("n cannot be less than 1");
    }
    long startTime = System.nanoTime();

    long sum = 0;

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= i; j++) {

        sum++;

      }

    }

    long endTime = System.nanoTime();
    System.out.println("Time Taken in ms: " + (endTime - startTime) / 1000000);
    return sum;
  }

}
