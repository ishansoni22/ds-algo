package com.ishan.dsalgo.recursion;

public class GenerateSubsets {

  public GenerateSubsets(String input) {
    String current = "";
    int index = 0;
    generate(input, current, index);
  }

  private void generate(String input, String current, int index) {

    if (index >= input.length()) {
      System.out.println(current);
      return;
    }

    generate(input, current, index + 1);
    generate(input, current + input.charAt(index), index + 1);

  }

  public static void main(String[] args) {

    GenerateSubsets generateSubsets = new GenerateSubsets("ABC");
  }

}
