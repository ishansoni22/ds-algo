package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Input n
 Sum of First n odd and First n even numbers separated by space
 */
public class SumEvenOdd {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    long n = Long.parseLong(br.readLine());

    System.out.print((n * n) + " ");
    System.out.print(n * (n + 1));
  }

}
