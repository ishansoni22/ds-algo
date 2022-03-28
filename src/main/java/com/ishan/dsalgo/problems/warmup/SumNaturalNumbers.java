package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 You are given a number N. Find the sum of all numbers from 1 to N.

 First-line will contain the number N.

 Print the answer in a single line.
*/
public class SumNaturalNumbers {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    long n = Long.parseLong(br.readLine());
    System.out.println((n * (n + 1)) / 2);

  }

}
