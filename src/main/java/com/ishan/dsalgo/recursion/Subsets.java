package com.ishan.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

 */
public class Subsets {

  //Todo - Solve using Backtracking!

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    g(nums, new ArrayList<>(), subsets, 0);
    return subsets;
  }

  private void g(int[] nums, List<Integer> subsets, List<List<Integer>> allSubsets, int i) {
    if (i == nums.length) {
      allSubsets.add(subsets);
    } else {
      //Ignore the current index number
      g(nums, new ArrayList<>(subsets), allSubsets, i + 1);
      //Include the current index number
      subsets.add(nums[i]);
      g(nums, subsets, allSubsets, i + 1);
    }
  }

  public static void main(String[] args) {
    Subsets s = new Subsets();
    System.out.println(s.subsets(new int[]{1, 2, 3}));
  }

}
