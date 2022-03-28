package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 You are given a list of N integers and you need to reverse it and print the reversed list in a new line.

 First-line will contain the number N.

 Second line will contain N space-separated integers.

 Print the reversed list in a single line.

 */
public class ReverseMe {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int n = Integer.parseInt(br.readLine());

    String[] arr = br.readLine().split(" ");
    for (int i = arr.length - 1; i >= 0; i--) {
      System.out.print(arr[i] + " ");
    }

  }

}
