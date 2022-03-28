package com.ishan.dsalgo.problems.warmup;

/*
Given a sorted array of distinct integers and a target value,
return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

 */
public class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    if (target < nums[0]) {
      return 0;
    } else if (target > nums[nums.length - 1]) {
      return nums.length;
    }

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    SearchInsertPosition sip = new SearchInsertPosition();
    System.out.println(sip.searchInsert(new int[]{1, 3, 5, 7}, 6));

  }

}
