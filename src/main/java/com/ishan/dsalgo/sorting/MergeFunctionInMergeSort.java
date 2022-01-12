package com.ishan.dsalgo.sorting;

public class MergeFunctionInMergeSort {

  public void merge(int[] arr, int low, int mid, int high) {
    //Inclusive of mid element
    int firstArrayElements = mid - low + 1;
    //Exclusive of mid element
    int secondArrayElements = high - mid;

    int[] first = new int[firstArrayElements];
    int[] second = new int[secondArrayElements];

    //Copy elements

    for (int i = 0; i < firstArrayElements; i++) {
      first[i] = arr[low + i];
    }

    for (int i = 0; i < secondArrayElements; i++) {
      second[i] = arr[mid + i + 1];
    }

    //Merge these 2 sorted arrays back into arr (See Merge sorted Arrays)

  }

  public static void main(String[] args) {

  }

}
