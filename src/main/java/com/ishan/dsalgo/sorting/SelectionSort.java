package com.ishan.dsalgo.sorting;

import java.util.Arrays;

public class SelectionSort {

  public int[] sort(int[] arr) {

    for (int i = 0; i < arr.length - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
      }
      swap(arr, i, minIdx);
    }
    return arr;
  }

  private void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static void main(String[] args) {
    SelectionSort selectionSort = new SelectionSort();
    System.out.println(Arrays.toString(selectionSort.sort(new int[]{1, 5, 4, 10, 8})));
  }

}
