package com.ishan.dsalgo.recursion;

/*
Given a string, generate all its Permutations
 */
public class GeneratePermutations {

  //Todo - Solve using Backtracking

  public void generateNaive2(String input) {
    generateNaive2(input, 0, input.length() - 1);
  }

  private void generateNaive2(String input, int l, int r) {
    if (l == r) {
      System.out.println(input);
    } else {
      for (int i = l; i <= r; i++) {
        //Change the string
        input = swap(input, l, r);
        generateNaive2(input, l + 1, r);
        //Revert to the original string for the next pass (Backtracking?)
        input = swap(input, l, r);
      }
    }
  }

  private String swap(String input, int l, int r) {
    char[] arr = input.toCharArray();
    char temp = arr[r];
    arr[r] = arr[l];
    arr[l] = temp;
    return new String(arr);
  }

  //Does not work if the string has duplicate characters. Example ABB
  public void generateNaive1(String input) {
    generateNaive1(input, "", 0);
  }

  private void generateNaive1(String input, String current, int index) {
    if (current.length() == input.length()) {
      System.out.println(current);
    } else {
      for (int i = 0; i < input.length(); i++) {
        if (current.indexOf(input.charAt(i)) < 0) {
          generateNaive1(input, current + input.charAt(i), index + 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    GeneratePermutations gp = new GeneratePermutations();
    gp.generateNaive2("ABCD");
  }

}
