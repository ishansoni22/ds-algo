package com.ishan.dsalgo.prefixSum;

/*
Given n ranges, find the maximum appearing element in these ranges

Example:
l: [1, 2, 5, 15]
r: [5, 8, 7, 18]

l.length = r.length

A ranges is from l[i] - r[i]

Ranges:

1-5:   1, 2, 3, 4, 5
2-8:   2, 3, 4, 5, 6, 7, 8
5-7:   5, 6, 7
15-18: 15, 16, 17, 18

o/p: 5

 */
public class MaximumFrequencyInRanges {

  //Naive solution?
  //1 - Traverse each range and put the frequency of each element in a hash map. Find the max frequency.
  //2 - or, of the items are small (eg 0 <= l[i], r[i] <=1000), you can use an array as a hash table

  //Can you do better? - Can you do it by only traversing the ranges array and not the entire range?

  public int maxFrequency(int l[], int r[]) {
    //Use an array as a hash table if the range of number is small (eg 0 <= 999)
    int[] arr = new int[1000];

    for (int i = 0; i < l.length; i++) {
      arr[l[i]]++;
      arr[r[i] + 1]--;
    }

    //Compute Prefix Sum array
    int maxIdx = 0;
    for (int i = 1; i < arr.length; i++) {
      arr[i] += arr[i - 1];
      if (arr[i] > arr[maxIdx]) {
        maxIdx = i;
      }
    }
    return maxIdx;
  }

}
