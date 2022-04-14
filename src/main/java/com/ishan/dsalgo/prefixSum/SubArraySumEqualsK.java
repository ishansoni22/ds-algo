package com.ishan.dsalgo.prefixSum;

import java.util.HashMap;
import java.util.Map;

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
    int count = 0;
    int sum = 0;
    Map<Integer, Integer> prefixSumOccurrenceMap = new HashMap<>();
    prefixSumOccurrenceMap.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (prefixSumOccurrenceMap.containsKey(sum - k)) {
        count += prefixSumOccurrenceMap.get(sum - k);
      }
      prefixSumOccurrenceMap.put(sum, prefixSumOccurrenceMap.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    SubArraySumEqualsK s = new SubArraySumEqualsK();
    System.out.println(
        s.subarraySum(
            new int[]{1, 2, 3, 4, 5, 6, 7},
            15));
  }

}