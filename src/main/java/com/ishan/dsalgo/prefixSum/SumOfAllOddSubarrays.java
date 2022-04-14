package com.ishan.dsalgo.prefixSum;

/*
Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.

Return the sum of all odd-length subarrays of arr.

Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.

Example 3:

Input: arr = [10,11,12]
Output: 66

 */
public class SumOfAllOddSubarrays {

  //[1, 2, 3, 4]
  //i = 0, s - 1, 3, 5(x) and you start at 0
  //i = 1, s - 1 - 3 and you start at 1
  public int sumOddLengthSubarraysNaive(int[] arr) {
    int sum = 0;
    //i denotes the start element of the sub-array
    for (int i = 0; i < arr.length; i++) {
      //s denotes the size of the sub-array that starts at i
      for (int s = 1; s <= arr.length - i; s += 2) {
        int size = s;
        int start = i;
        //calculate sum of the sub-array that starts at i and has s elements
        while (size != 0) {
          sum += arr[start++];
          --size;
        }
      }
    }
    return sum;
  }

  public int sumOddLengthSubarrays(int[] arr) {
    int sum = 0;
    //Create the Prefix Sum Array
    for (int i = 1; i < arr.length; i++) {
      arr[i] = arr[i] + arr[i - 1];
    }

    //For each i, take sum of the odd sub-arrays starting from i
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j += 2) {
        sum += getSubArraySumFrom(i, j, arr);
      }
    }
    return sum;
  }

  private int getSubArraySumFrom(int l, int r, int[] arr) {
    if (l == 0) {
      return arr[r];
    }
    return arr[r] - arr[l - 1];
  }

  public static void main(String[] args) {
    SumOfAllOddSubarrays s = new SumOfAllOddSubarrays();
    System.out.println(s.sumOddLengthSubarraysNaive(new int[]{1, 2, 3, 4}));
    System.out.println(s.sumOddLengthSubarrays(new int[]{1, 2, 3, 4}));
  }

}
