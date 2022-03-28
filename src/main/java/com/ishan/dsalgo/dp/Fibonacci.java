package com.ishan.dsalgo.dp;

public class Fibonacci {

  public Long calculateUsingMemoization(Long i, Long[] memo) {
    int index = i.intValue();
    if (memo[index] != null) {
      return memo[index];
    }

    if (i == 0 || i == 1) {
      return i;
    }

    Long solution = calculateUsingMemoization(i - 1, memo) + calculateUsingMemoization(i - 2, memo);
    memo[index] = solution;
    return solution;
  }

  public Long calculateUsingTabulation(int n) {
    Long[] f = new Long[n + 1];

    f[0] = 0L;
    f[1] = 1L;

    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }

  //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    long startTime = System.nanoTime();
    long solution = fibonacci.calculateUsingTabulation(50);
    long endTime = System.nanoTime();
    System.out.println(solution);
    System.out.println("Time Taken " + (endTime - startTime) / 1_000_000_000 + " seconds");
  }

}
