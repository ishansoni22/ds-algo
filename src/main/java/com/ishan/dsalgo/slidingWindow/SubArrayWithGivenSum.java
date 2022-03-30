package com.ishan.dsalgo.slidingWindow;

/*
Given an unsorted array of "non-negative" integers and an integer k,
return if there exists a sub-array whose sum is equal to k

 */
public class SubArrayWithGivenSum {

  //Brute Force
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

  public boolean subarraySumMySolution(int[] nums, int k) {
    int currentSum = 0;
    int startWindow = 0;

    for (int endWindow = 0; endWindow < nums.length; endWindow++) {
      currentSum += nums[endWindow];
      if (currentSum > k) {
        while (currentSum > k && startWindow < endWindow) {
          currentSum -= nums[startWindow++];
          if (currentSum == k) {
            return true;
          }
        }
      }
      if (currentSum == k) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    SubArrayWithGivenSum s = new SubArrayWithGivenSum();
    System.out.println(s.subarraySumMySolution(new int[]{1, 4, 20, 3, 10, 85}, 85));
  }

}
