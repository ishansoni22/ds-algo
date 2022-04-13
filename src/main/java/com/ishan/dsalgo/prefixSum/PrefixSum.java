package com.ishan.dsalgo.prefixSum;

public class PrefixSum {

  private static int[] prefixSumOf(int[] arr) {
    int[] prefixSum = new int[arr.length];
    prefixSum[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
    return prefixSum;
  }

  //O(1) after the prefix sum array has been computed
  public static int computeSumBetween(int l, int r, int[] prefixSumArr) {
    if (l == 0) {
      return prefixSumArr[r];
    } else {
      return prefixSumArr[r] - prefixSumArr[l - 1];
    }
  }

  public static void main(String[] args) {
    int[] prefixSumArr = prefixSumOf(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    System.out.println(computeSumBetween(0, 2, prefixSumArr));
    System.out.println(computeSumBetween(3, 7, prefixSumArr));
  }

}
