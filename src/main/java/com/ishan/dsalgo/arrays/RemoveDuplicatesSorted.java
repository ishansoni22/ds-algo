package com.ishan.dsalgo.arrays;

/*
Remove Duplicate elements from a sorted array in place.
Return the distinct numbers of elements
 */
public class RemoveDuplicatesSorted {

  public int removeDuplicates(int[] nums) {
    int currentDistinctIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[currentDistinctIndex]) {
        ++currentDistinctIndex;
        nums[currentDistinctIndex] = nums[i];
      }
    }
    return currentDistinctIndex + 1;
  }

  public static void main(String[] args) {
    RemoveDuplicatesSorted r = new RemoveDuplicatesSorted();
    System.out.println(r.removeDuplicates(new int[]{0, 0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 5}));
  }

}
