package com.ishan.dsalgo.arrays;

import java.util.Arrays;

/*
Input : 1 0 0 1 0 1 0 1 1 1 1 1 1 0 0 1 1 0 1 0 0
Output : 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
Explanation: The output is a sorted array of 0 and 1

Input : 1 0 1 0 1 0 1 0
Output : 0 0 0 0 1 1 1 1
Explanation: The output is a sorted array of 0 and 1
 */
public class SortBinaryArray {

  public void sort1(int[] arr) {
    int zeros = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 1) {
        ++zeros;
      }
    }

    for (int i = 0; i < arr.length; i++) {
      if (zeros > 0) {
        arr[i] = 0;
        --zeros;
      } else {
        arr[i] = 1;
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  public void sort2(int[] arr) {
    int j = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 1) {
        ++j;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    SortBinaryArray sba = new SortBinaryArray();
    sba.sort2(new int[]{1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0});
  }

}
