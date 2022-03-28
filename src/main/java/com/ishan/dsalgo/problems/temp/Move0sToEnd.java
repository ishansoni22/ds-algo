package com.ishan.dsalgo.problems.temp;

import java.util.Arrays;

public class Move0sToEnd {

  private int[] move(int[] nums) {
    int lastNon0Index = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        ++lastNon0Index;
        int temp = nums[lastNon0Index];
        nums[lastNon0Index] = nums[i];
        nums[i] = temp;
      }
    }
    return nums;
  }

  //Intuitive

  /*

  You have already handled the first 4 elements
  4 5 0 0

  Now, the fifth element can be either 0 or non-0

  If 0, don't do anything - 4 5 0 0 0

  If non-0, you need to swap this element with the first 0! (How do you find the first 0 - countNon0)

   */
  public int[] moveIntuitive(int[] nums) {
    int countNon0 = 0;

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] != 0) {
        int temp = nums[countNon0];
        nums[countNon0] = nums[i];
        nums[i] = temp;
        ++countNon0;
      }
    }
    return nums;
  }


  public static void main(String[] args) {
    Move0sToEnd move0sToEnd = new Move0sToEnd();
    System.out.println(Arrays.toString(move0sToEnd.move(new int[]{0, 1, 2, 3, 0})));
  }

}
