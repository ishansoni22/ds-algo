package com.ishan.dsalgo.slidingWindow;

/*
Given an unsorted array of "non-negative" integers and an integer k,
return if there exists a sub-array whose sum is equal to k

 */
public class SubArrayWithGivenSum {

  public boolean subarraySumNaive(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) {
          return true;
        } else if (sum > k) {
          break;
        }
      }
    }
    return false;
  }

  public boolean subarraySum(int[] nums, int k) {
    int current_Sum = nums[0];

    if (current_Sum == k) {
      return true;
    }

    for (int i = 1; i < nums.length; i++) {

      while (current_Sum < k) {

      }

    }

    return false;
  }

}
