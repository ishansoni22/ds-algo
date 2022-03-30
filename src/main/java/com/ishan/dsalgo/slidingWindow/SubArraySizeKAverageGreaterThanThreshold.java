package com.ishan.dsalgo.slidingWindow;

/*
Given an array of integers arr and two integers k and threshold,
return the number of sub-arrays of size k and average greater than or equal to threshold.

Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).

Example 2:

Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.

 */
public class SubArraySizeKAverageGreaterThanThreshold {

  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int count = 0;
    if (arr.length < k) {
      return count;
    }

    //Initial Window [left, right)
    int left = 0;
    int right = k;

    int sum = 0;
    for (int i = left; i < right; i++) {
      sum += arr[i];
    }

    if (isAvgAboveThreshold(sum, k, threshold)) {
      ++count;
    }

    for (; right < arr.length; right++) {
      sum += arr[right];
      sum -= arr[left++];

      if (isAvgAboveThreshold(sum, k, threshold)) {
        ++count;
      }
    }

    return count;
  }

  private boolean isAvgAboveThreshold(int sum, int count, int threshold) {
    return sum / count >= threshold;
  }

  public static void main(String[] args) {
    SubArraySizeKAverageGreaterThanThreshold s = new SubArraySizeKAverageGreaterThanThreshold();
    System.out.println(s.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
  }

}
