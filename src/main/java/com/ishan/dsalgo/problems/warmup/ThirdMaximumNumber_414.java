package com.ishan.dsalgo.problems.warmup;

public class ThirdMaximumNumber_414 {

  Integer find(int[] nums) {
    Integer largest = nums[0];
    Integer secondLargest = null;
    Integer thirdLargest = null;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > largest) {
        thirdLargest = secondLargest;
        secondLargest = largest;
        largest = nums[i];
      } else if (nums[i] < largest) {
        if (secondLargest == null) {
          secondLargest = nums[i];
        } else {
          if (nums[i] > secondLargest) {
            thirdLargest = secondLargest;
            secondLargest = nums[i];
          } else if (nums[i] < secondLargest) {
            if (thirdLargest == null) {
              thirdLargest = nums[i];
            } else {
              if (nums[i] > thirdLargest) {
                thirdLargest = nums[i];
              }
            }
          }
        }
      }
    }
    return thirdLargest == null ? largest : thirdLargest;
  }

  public static void main(String[] args) {
    ThirdMaximumNumber_414 obj = new ThirdMaximumNumber_414();
    int[] input = {3, 2, 1};
    System.out.println(obj.find(input));

  }

}
