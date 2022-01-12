package leetcode.easy;

import java.util.HashMap;

public class TwoSum {

  public int[] find(int[] nums, int target) {
    HashMap<Integer, Integer> tracker = new HashMap<>();
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      int num = nums[i];
      if (tracker.containsKey(num)) {
        return new int[]{i, tracker.get(num)};
      } else {
        tracker.put(target - nums[i], i);
      }

    }
    return null;
  }

  public int[] findUsingBruteForce(int[] nums, int target) {

    int length = nums.length;
    for (int i = 0; i < length; i++) {

      for (int j = i + 1; j < length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    TwoSum obj = new TwoSum();
    int[] input = {3, 3};
    int target = 6;
    PrintUtil.printIntArray(obj.find(input, target));
  }

}
