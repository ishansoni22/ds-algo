package com.ishan.dsalgo.twoPointers;

/*
https://leetcode.com/problems/container-with-most-water/

You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

 */
public class ContainerWithMostWater {

  /*
  Calculate area b/w every pair of lines
   */
  public int maxAreaBruteForce(int[] height) {
    int max = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int currentArea = Math.min(height[i], height[j]) * (j - i);
        max = Math.max(max, currentArea);
      }
    }
    return max;
  }

  /*
  Two pointer
  Start with l = 0, r = length - 1
  Calculate area and check max, move away from the shorter line at each iteration - Think!
   */
  public int maxArea(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int currentArea = Math.min(height[left], height[right]) * (right - left);
      max = Math.max(max, currentArea);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    ContainerWithMostWater c = new ContainerWithMostWater();
    System.out.println(c.maxAreaBruteForce(new int[]{4, 2, 7, 3, 6}));
    System.out.println(c.maxArea(new int[]{4, 2, 7, 3, 6}));
  }

}
