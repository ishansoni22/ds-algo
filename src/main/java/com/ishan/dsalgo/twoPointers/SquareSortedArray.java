package com.ishan.dsalgo.twoPointers;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 */
public class SquareSortedArray {

  //O(nlogn)
  public int[] sortedSquaresNaive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] * nums[i];
    }

    Arrays.sort(nums);

    return nums;
  }

  public int[] sortedSquares(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    int[] sorted = new int[nums.length];
    int i = nums.length - 1;

    while (i >= 0) {
      if (Math.abs(nums[l]) > Math.abs(nums[r])) {
        sorted[i] = nums[l] * nums[l];
        ++l;
      } else {
        sorted[i] = nums[r] * nums[r];
        --r;
      }
      --i;
    }
    return sorted;
  }

  public static void main(String[] args) {
    SquareSortedArray ssa = new SquareSortedArray();
    System.out.println(Arrays.toString(ssa.sortedSquares(new int[]{-3, -2, -1})));
  }

}
