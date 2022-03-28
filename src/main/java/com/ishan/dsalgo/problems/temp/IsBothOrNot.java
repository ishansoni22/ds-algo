package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 You're given a number N.
 If N is divisible by 5 or 11 but not both then print "ONE"(without quotes).
 If N is divisible by both 5 and 11 then print "BOTH"(without quotes).
 If N is not divisible by 5 or 11 then print "NONE"(without quotes).

 First-line will contain the number N

 Print the answer in a newline.

 */
public class IsBothOrNot {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int number = Integer.parseInt(br.readLine());

    boolean by5 = number % 5 == 0;
    boolean by11 = number % 11 == 0;

    if (by5 && by11) {
      System.out.println("BOTH");
    } else if (by5 || by11) {
      System.out.println("ONE");
    } else {
      System.out.println("NONE ");
    }
  }

}
