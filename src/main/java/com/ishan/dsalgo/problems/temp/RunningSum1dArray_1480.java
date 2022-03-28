package com.ishan.dsalgo.problems.temp;

import com.ishan.dsalgo.problems.warmup.PrintUtil;

public class RunningSum1dArray_1480 {

  public int[] runningSum(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      int previous = 0;
      if (i != 0) {
        previous = nums[i - 1];
      }
      nums[i] = nums[i] + previous;
    }

    return nums;
  }

  public static void main(String[] args) {
    RunningSum1dArray_1480 obj = new RunningSum1dArray_1480();
    int input[] = {3, 1, 2, 10, 1};
    PrintUtil.printIntArray(obj.runningSum(input));
  }

}
