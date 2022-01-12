package com.ishan.dsalgo.sorting;

import java.util.Arrays;

public class MergeSortedArrays {

  public int[] merge(int[] arr1, int[] arr2) {
    int arr1Length = arr1.length;
    int arr2Length = arr2.length;
    int[] output = new int[arr1Length + arr2Length];
    int track = 0;
    int track1 = 0;
    int track2 = 0;

    while (track1 < arr1Length && track2 < arr2Length) {
      if (arr1[track1] <= arr2[track2]) {
        output[track] = arr1[track1];
        ++track1;
      } else {
        output[track] = arr2[track2];
        ++track2;
      }
      ++track;
    }

    while (track1 < arr1Length) {
      output[track] = arr1[track1];
      ++track1;
      ++track;
    }

    while (track2 < arr2Length) {
      output[track] = arr2[track2];
      ++track2;
      ++track;
    }

    return output;
  }

  public static void main(String[] args) {
    MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
    System.out.println(Arrays.toString(mergeSortedArrays.merge(
        new int[]{10, 15, 20},
        new int[]{5, 6, 6, 15}
    )));
  }
}
