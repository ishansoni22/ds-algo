package com.ishan.dsalgo.prefixSum;

/*
Given an array, find if it has an equilibrium point/pivot index
i.e sum of elements before it = sum of elements after it
 */
public class EquilibriumPointOrPivotIndex {

  public int pivotIndex(int[] nums) {

    //Calculate Prefix Sum Array
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i - 1] + nums[i];
    }

    for (int i = 0; i < nums.length; i++) {
      if (getLeft(i, nums) == getRight(i, nums)) {
        return i;
      }
    }

    return -1;
  }

  private int getLeft(int i, int[] prefixSumArr) {
    if (i == 0) {
      return 0;
    } else {
      return prefixSumArr[i - 1];
    }
  }

  private int getRight(int i, int[] prefixSumArr) {
    if (i == prefixSumArr.length - 1) {
      return 0;
    } else {
      return prefixSumArr[prefixSumArr.length - 1] - prefixSumArr[i];
    }
  }

}
