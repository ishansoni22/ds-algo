package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 Chef went to a shop and buys a pens and b pencils.
 Each pen costs x units and each pencil costs y units.
 Now find what is the total amount Chef will spend to buy a pens and b pencils.

 First-line will contain 4 space separated integers a, b, x and y respectively.

 Print the answer in a new line.

 */
public class BuyPlease {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    int count = 0;
    int[] inputs = {0, 0, 0, 0};

    while (stringTokenizer.hasMoreElements()) {
      inputs[count] = Integer.parseInt(stringTokenizer.nextToken());
      ++count;
    }

    System.out.println(inputs[0] * inputs[2] + inputs[1] * inputs[3]);

  }

}
