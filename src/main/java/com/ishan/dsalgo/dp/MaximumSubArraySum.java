package com.ishan.dsalgo.dp;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

*/
public class MaximumSubArraySum {

  public int bruteForce(int[] nums) {
    int maxSum = nums[0];
    //Todo - Do in 2 Loops!

    for (int window = 1; window <= nums.length; window++) {
      for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < Math.min(i + window, nums.length); j++) {
          sum += nums[j];
        }
        if (sum > maxSum) {
          maxSum = sum;
        }
      }
    }
    return maxSum;
  }

  public int betterBruteForce(int[] nums) {
    //Todo
    return 0;
  }

  /*
  Kadane's Algorithm
  https://youtu.be/86CQq3pKSUw
   */
  public int maxSubArray(int[] nums) {
    int max_sum = nums[0];
    int current_sum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      current_sum = Math.max(current_sum + nums[i], nums[i]);

      if (current_sum > max_sum) {
        max_sum = current_sum;
      }
    }

    return max_sum;
  }

  public static void main(String[] args) {
    MaximumSubArraySum msas = new MaximumSubArraySum();
    System.out.println(msas.maxSubArray(
        new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

}
