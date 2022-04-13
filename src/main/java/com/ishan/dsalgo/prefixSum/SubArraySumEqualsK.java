package com.ishan.dsalgo.prefixSum;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 */
public class SubArraySumEqualsK {

  public int subarraySumBruteForce(int[] nums, int k) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) {
          ++count;
        }
      }
    }
    return count;
  }

  public int subarraySum(int[] nums, int k) {
    return -1;
  }

  public static void main(String[] args) {
    SubArraySumEqualsK s = new SubArraySumEqualsK();
    System.out.println(
        s.subarraySum(
            new int[]{1, 2, 3, 4, 5, 6, 7},
            15));
  }

}