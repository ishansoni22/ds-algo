package com.ishan.dsalgo.sorting;

import java.util.Arrays;

public class InsertionSort {

  public int[] sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int elem = arr[i];
      int checkIdx = i - 1;
      while (elem < arr[checkIdx] && checkIdx >= 0) {
        arr[checkIdx + 1] = arr[checkIdx];
        checkIdx--;
      }
      arr[checkIdx + 1] = elem;
    }
    return arr;
  }

  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();
    System.out.println(
        Arrays.toString(insertionSort.sort(new int[]{1, 5, 4, 10, 8, 13, 12, 6, 78, 40, 100})));
  }

}
