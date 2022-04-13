package com.ishan.dsalgo.searching;

public class BinarySearchIterative {

  public int find(int[] arr, int elem) {
    int beginIdx = 0;
    int endIdx = arr.length - 1;

    while (beginIdx <= endIdx) {
      int middleIdx = (beginIdx + endIdx) / 2;
      if (arr[middleIdx] == elem) {
        return middleIdx;
      } else if (arr[middleIdx] < elem) {
        beginIdx = middleIdx + 1;
      } else {
        endIdx = middleIdx - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    BinarySearchIterative binarySearchIterative = new BinarySearchIterative();
    int input[] = {1, 2, 3};
    int elem = 1;
    System.out.println(binarySearchIterative.find(input, elem));
  }

}
