package com.ishan.dsalgo.problems.temp;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.add(nums[i])) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicate cd = new ContainsDuplicate();
    System.out.println(cd.containsDuplicate(new int[]{3, 3}));
  }

}
