package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 You are given a number N and find all the distinct factors of N

 First-line will contain the number N

 In the first line print number of distinct factors of N.
 In the second line print all distinct factors in ascending order separated by space.

 */
public class FactorsFinding {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int number = Integer.parseInt(br.readLine());

    int numberOfFactors = 0;
    StringBuilder output = new StringBuilder();
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        ++numberOfFactors;
        output.append(i).append(" ");
      }
    }
    System.out.println(numberOfFactors);
    System.out.println(output);
  }

}
