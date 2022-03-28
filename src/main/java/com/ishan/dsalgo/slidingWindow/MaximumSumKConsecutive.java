package com.ishan.dsalgo.slidingWindow;

/*
 Given an array of integers of size ‘n’.
 Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.

 Example:
 Input  : arr[] = {100, 200, 300, 400}
        : k = 2
 Output : 700

 */
public class MaximumSumKConsecutive {

  public int sum(int[] array, int k) {

    if (k > array.length) {
      return 0;
    }

    int maxSum = 0;

    //Calculate the sum of the 1st Window (First consecutive elements)
    int currentWindowSum = 0;
    for (int i = 0; i < k; i++) {
      currentWindowSum += array[i];
    }

    maxSum = currentWindowSum;

    //Slide the window 1 step at a time!
    //[x][x][ ][ ][ ]
    //[ ][x][x][ ][ ] --> Start from k(next slide). Add this slide and remove the leftmost of the last slide!
    //[ ][ ][x][x][ ]
    for (int i = k; i < array.length; i++) {
      currentWindowSum = currentWindowSum + array[i] - array[i - k];
      if (currentWindowSum > maxSum) {
        maxSum = currentWindowSum;
      }
    }

    return maxSum;

  }

  public static void main(String[] args) {
    MaximumSumKConsecutive slidingWindowExample = new MaximumSumKConsecutive();
    System.out.println(slidingWindowExample.sum(new int[]{100, 200, 300, 400}, 2));
  }

}
