package com.ishan.dsalgo.arrays;

import com.ishan.dsalgo.problems.warmup.PrintUtil;

public class Reverse {

  public int[] reverse(int arr[]) {
    final int length = arr.length;
    for (int i = 0; i < length / 2; i++) {
      int swapIndex = length - i - 1;
      int temp = arr[i];
      arr[i] = arr[swapIndex];
      arr[swapIndex] = temp;
    }
    return arr;
  }

  public static void main(String[] args) {
    Reverse reverse = new Reverse();
    int[] input = {1, 2, 3, 4, 5};
    PrintUtil.printIntArray(reverse.reverse(input));

  }

}
