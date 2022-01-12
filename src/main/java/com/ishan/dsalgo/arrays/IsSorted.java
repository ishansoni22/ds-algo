package com.ishan.dsalgo.arrays;

public class IsSorted {

  public boolean isSorted(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    IsSorted isSorted = new IsSorted();
    int[] input = {7, 20, 30, 40};
    System.out.println(isSorted.isSorted(input));
  }

}
