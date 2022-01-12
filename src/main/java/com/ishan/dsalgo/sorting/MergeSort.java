package com.ishan.dsalgo.sorting;

import java.util.Arrays;

public class MergeSort {

  public void mergeSort(int[] arr, int low, int high) {
    if (high > low) {
      int mid = low + (high - low) / 2;
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }

  private void merge(int[] arr, int low, int mid, int high) {
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

    int track = low;
    int track1 = 0;
    int track2 = 0;

    while (track1 < firstArrayElements && track2 < secondArrayElements) {
      if (first[track1] <= second[track2]) {
        arr[track] = first[track1];
        ++track1;
      } else {
        arr[track] = second[track2];
        ++track2;
      }
      ++track;
    }

    while (track1 < firstArrayElements) {
      arr[track] = first[track1];
      ++track1;
      ++track;
    }

    while (track2 < secondArrayElements) {
      arr[track] = second[track2];
      ++track2;
      ++track;
    }

  }

  public static void main(String[] args) {
    MergeSort mergeSort = new MergeSort();
    int[] arr = new int[]{5, 2, 78, 40, 20, 100, 2};
    mergeSort.mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

}
