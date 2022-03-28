package com.ishan.dsalgo.arrays;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6] //7-3
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Example 3:

Input: nums = [1, 2], k = 3
Output: [2, 1]
1: 2, 1
2: 1, 2
3: 2, 1

 */
public class RotateArray {

  //Approach - Store last variable in temp. Move all items starting from n-2 index -> next //position!
  //[1,2,3,4,5,6,7]
  //temp=7
  //[1][1][2][3][4][5][6]
  //[7][1][2][3][4][5][6]
  public int[] rotateBy1(int[] nums) {
    //Todo
    return nums;
  }

  //See Explanation in Sketch!
  //1,2,3,4,5,6,7

  //4,3,2,1 5,6,7
  //4,3,2,1 7,6,5
  //5,6,7,1,2,3,4
  public void rotate(int[] nums, int k) {
    if (nums.length == 1) {
      return;
    }

    k = k % nums.length;

    if (k == 0) {
      return;
    }

    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);

  }

  //Two - Pointers
  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      ++start;
      --end;
    }
  }

  /*
  Idea :
  If the array has a single element, do nothing. All rotations will result in that single element

  Find effective rotations. Rotating an array of length k, k times will result in the same array

  Array - [1,2,3,4,5,6,7]
  Copy [5,6,7] to start of a new array
  then copy 1,2,3,4 to end of the new array
  copy back to original array

   */
  public int[] rotateNaive1(int[] nums, int k) {
    if (nums.length == 1) {
      return nums;
    }

    k = k % nums.length;

    if (k == 0) {
      return nums;
    }

    int[] temp = new int[nums.length];
    int sizeTemp = 0;

    for (int i = nums.length - k; i < nums.length; i++, sizeTemp++) {
      temp[sizeTemp] = nums[i];
    }

    for (int i = 0; i < nums.length - k; i++, sizeTemp++) {
      temp[sizeTemp] = nums[i];
    }

    for (int i = 0; i < temp.length; i++) {
      nums[i] = temp[i];
    }

    return nums;
  }

  /*
  The idea is the same as the first naive solution, but instead of a new array, use a new
  doubly linked list and manipulate heads and tails during each rotation
   */
  public int[] rotateNaive2(int[] nums, int k) {
    if (nums.length == 1) {
      return nums;
    }

    k = k % nums.length;

    if (k == 0) {
      return nums;
    }

    //Create a Doubly Linked List from an array
    Node head = new Node();
    head.value = nums[0];
    Node tail = head;

    Node previous = head;

    for (int i = 1; i < nums.length; i++) {
      Node current = new Node();
      current.value = nums[i];

      current.previous = previous;
      previous.next = current;
      previous = current;

      if (i == nums.length - 1) {
        tail = current;
      }
    }

    //Rotate
    for (int i = 1; i <= k; i++) {
      tail.next = head;
      head.previous = tail;

      head = tail;
      tail = tail.previous;
      head.previous = null;
      tail.next = null;
    }

    //Convert List back to Array
    Node iterator = head;
    int idx = 0;
    while (iterator != null) {
      nums[idx] = iterator.value;
      ++idx;
      iterator = iterator.next;
    }

    return nums;
  }

  public static void main(String[] args) {
    RotateArray rotateArray = new RotateArray();
    System.out
        .println(Arrays.toString(rotateArray.rotateNaive1(new int[]{1, 2, 3}, 4)));
  }

  private class Node {

    int value;
    Node next;
    Node previous;
  }

}
