package com.ishan.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

 */
public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> allPermutations = new ArrayList<>();
    List<Integer> currentPermutation = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      currentPermutation.add(nums[i]);
    }
    p(currentPermutation, allPermutations, 0, nums.length - 1);
    return allPermutations;
  }

  private void p(List<Integer> currentPermutation, List<List<Integer>> allPermutations,
      int l, int r) {
    if (l == r) {
      allPermutations.add(new ArrayList<>(currentPermutation));
    } else {
      for (int i = l; i <= r; i++) {
        swap(currentPermutation, i, l);
        p(currentPermutation, allPermutations, l + 1, r);
        swap(currentPermutation, i, l);
      }
    }

  }

  private void swap(List<Integer> currentPermutation, int i, int l) {
    int temp = currentPermutation.get(i);
    currentPermutation.set(i, currentPermutation.get(l));
    currentPermutation.set(l, temp);
  }

  public static void main(String[] args) {
    Permutations p = new Permutations();
    System.out.println(p.permute(new int[]{1, 2, 3}));
  }

}
