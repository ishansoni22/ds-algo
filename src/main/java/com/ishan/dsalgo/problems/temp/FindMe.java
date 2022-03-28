package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 You are given a list of N integers and a value K.
 Print 1 if K exists in the given list of N integers, otherwise print −1.

 First-line will contain two numbers N and K.

 Next line contains N space-separated numbers.

 Print the answer in a new line.

 */
public class FindMe {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    String[] i = br.readLine().split(" ");
    int k = Integer.parseInt(i[1]);
    String p = "-1";
    for (String s : br.readLine().split(" ")) {
      if (k == Integer.parseInt(s)) {
        p = "1";
        break;
      }
    }
    System.out.println(p);
  }

}
