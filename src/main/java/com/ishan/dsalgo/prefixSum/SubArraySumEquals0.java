package com.ishan.dsalgo.prefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubArraySumEquals0 {

  //O(n2)
  public boolean subarraySumEquals0BruteForce(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == 0) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean subarraySumEquals0(int[] nums) {
    HashMap<Integer, List<Integer>> prefixSumMap = new HashMap<>();
    int sum = 0;
    List<Integer> subArray = new ArrayList<>();

    //So that it work for the following cases:
    //{0}
    //{-3, 2, 1}
    //Think!
    prefixSumMap.put(0, new ArrayList<>());

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      subArray.add(nums[i]);
      //Will also work for {1, 2, 0} - Think!
      if (prefixSumMap.containsKey(sum)) {
        prefixSumMap.get(sum).forEach(subArray::remove);
        System.out.println(subArray);
        return true;
      } else {
        prefixSumMap.put(sum, new ArrayList<>(subArray));
      }
    }
    return false;
  }

  public static void main(String[] args) {
    SubArraySumEquals0 subArraySumEquals0 = new SubArraySumEquals0();
    System.out.println(subArraySumEquals0.subarraySumEquals0(new int[]{0}));
  }

}
