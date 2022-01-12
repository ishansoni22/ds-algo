package com.ishan.dsalgo.searching;

public class BinarySearchRecursive {

  public int find(int[] arr, int elem, int begin, int end) {
    if (begin > end) {
      return -1;
    }
    int middleIdx = (begin + end) / 2;
    if (arr[middleIdx] == elem) {
      return middleIdx;
    } else if (arr[middleIdx] < elem) {
      return find(arr, elem, middleIdx + 1, end);
    } else {
      return find(arr, elem, begin, middleIdx - 1);
    }
  }

  public static void main(String[] args) {
    BinarySearchRecursive binarySearchRecursive = new BinarySearchRecursive();
    int[] input = {1, 1, 3, 5, 5, 10};
    int elem = 3;
    System.out.println(binarySearchRecursive.find(input, elem, 0, args.length - 1));
  }

}
