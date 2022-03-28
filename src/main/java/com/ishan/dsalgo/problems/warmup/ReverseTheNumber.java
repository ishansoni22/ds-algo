package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Given an Integer N, write a program to reverse it.

 The first line contains an integer T, total number of testcases.
 Then follow T lines, each line contains an integer N.

 For each test case, display the reverse of the given number N, in a new line.

 */
public class ReverseTheNumber {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int number = Integer.parseInt(br.readLine());
      boolean firstNonZeroEncountered = false;
      while (number > 0) {
        int r = number % 10;
        if (r == 0 && !firstNonZeroEncountered) {
        } else {
          firstNonZeroEncountered = true;
          System.out.print(r);
        }
        number = number / 10;
      }
      System.out.println();
      ++c;
    }

  }

}
