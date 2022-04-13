package com.ishan.dsalgo.prefixSum;

/*
Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 */
public class ProductOfArrayExceptSelf {

  //Brute Force
  public int[] productExceptSelfNaive1(int[] nums) {
    int[] prodArr = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int prod = 1;
      for (int j = 0; j < nums.length; j++) {
        if (i != j) {
          prod *= nums[j];
        }
      }
      prodArr[i] = prod;
    }
    return prodArr;
  }

  //A Better Naive Approach
  // - Compute product of the entire array in 1 pass
  // - In another pass for all i, divide product by i
  // - This won't work for [0, 1, 2, 3] - Think!

  public int[] productExceptSelfNaive2(int[] nums) {
    int prod = 1;
    for (int i = 0; i < nums.length; i++) {
      prod *= nums[i];
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = prod / nums[i];
    }
    return nums;
  }

  /*
  Invariant - For each i, output = product of numbers before it * product of numbers after it

  Prefix Multiplication Array: For each i, prefix[i] = Multiplicative value before i
  Suffix Multiplication Array: For each i, suffix[i] = Multiplicative value after i

  Final o/p for each i = prefix[i] * suffix[i]

   */
  public int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    int[] suffix = new int[nums.length];
    prefix[0] = 1;
    suffix[nums.length - 1] = 1;

    //Populate the prefix array
    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    //Populate the suffix array
    for (int i = nums.length - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = prefix[i] * suffix[i];
    }
    return nums;
  }

}
