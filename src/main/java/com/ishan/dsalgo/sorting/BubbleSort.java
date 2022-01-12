package com.ishan.dsalgo.sorting;

import java.util.Arrays;

public class BubbleSort {

  public int[] sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean swappedAny = false;
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swappedAny = true;
          swap(arr, j, j + 1);
        }
      }
      //No swapping done in a pass. Exiting
      if (!swappedAny) {
        break;
      }
    }
    return arr;
  }

  private void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static void main(String[] args) {
    BubbleSort bubbleSort = new BubbleSort();
    System.out.println(Arrays.toString(bubbleSort.sort(new int[]{1, 5, 4, 10, 8})));
  }

}
