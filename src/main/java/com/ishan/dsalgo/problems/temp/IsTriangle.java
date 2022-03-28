package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsTriangle {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    String[] arr = br.readLine().split(" ");
    int a = Integer.parseInt(arr[0]);
    int b = Integer.parseInt(arr[1]);
    int c = Integer.parseInt(arr[2]);
    int s = a + b + c;
    boolean v = s == 180 && a > 0 && b > 0 && c > 0;
    System.out.println(v ? "YES" : "NO");

  }

}
