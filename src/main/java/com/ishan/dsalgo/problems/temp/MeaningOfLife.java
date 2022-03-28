package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Your program is to use the brute-force approach in order to find the Answer to Life, the Universe, and Everything.
 More precisely… rewrite small numbers from input to output.
 Stop processing input after reading in the number 42. All numbers at input are integers of one or two digits.
 */
public class MeaningOfLife {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    while (true) {
      String n = br.readLine();
      if (n.equals("42")) {
        break;
      } else {
        System.out.println(n);
      }
    }

  }

}
