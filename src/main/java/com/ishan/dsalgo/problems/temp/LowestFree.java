package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Chef goes to the supermarket to buy some items.
Luckily there's a sale going on under which Chef gets the following offer:

If Chef buys 3 items then he gets the item (out of those 3 items) having the lowest price as free.

For e.g. if Chef bought 3 items with the cost 6, 2 and 4,
then he would get the item with cost 2 as free.
So he would only have to pay the cost of the other two items which will be 6+4=10.

Chef buys 3 items having prices A, B and C respectively. What is the amount of money Chef needs to pay?

The first line will contain an integer T - number of test cases. Then the test cases follow.

The first and only line of each test case contains three integers A,B,C - the prices of the items bought by Chef.

For each test case, output the price paid by Chef.

Constraints

1≤T≤100

1≤A,B,C≤10

Sample Input 1

3
6 2 4
3 3 3
8 4 4

Sample Output 1

10
6
12

 */
public class LowestFree {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int[] p = new int[3];
      int pc = 0;
      for (String pi : br.readLine().split(" ")) {
        p[pc] = Integer.parseInt(pi);
        ++pc;
      }

      Arrays.sort(p);

      System.out.println(p[1] + p[2]);
      ++c;
    }

  }

}
