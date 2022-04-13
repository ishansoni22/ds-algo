package com.ishan.dsalgo.searching;

import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order,
 find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 */
public class FirstAndLastPositionSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    boolean found = false;
    int[] result = new int[]{-1, -1};

    //Find the first position using binary search
    while (low <= high) {
      int mid = low + (high - low) / 2;
      //           mid
      //[] [x] [x] [x] [x]
      //Since you want to find the first index, you'll reduce high - Think
      if (nums[mid] == target) {
        found = true;
        high = mid - 1;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    if (!found) {
      return result;
    }

    //Find the last position using binary search
    result[0] = low;
    high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      //           mid
      //[] [x] [x] [x] [x] [x]
      //Since you want to find the first index, you'll increase low - Think
      if (nums[mid] == target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    result[1] = high;
    return result;
  }

  public static void main(String[] args) {
    FirstAndLastPositionSortedArray f = new FirstAndLastPositionSortedArray();
    System.out.println(Arrays.toString(
        f.searchRange(new int[]{5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 10}, 6)));
  }

}
