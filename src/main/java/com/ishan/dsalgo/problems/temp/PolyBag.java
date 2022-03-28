package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Chef bought N items from a shop.
Although it is hard to carry all these items in hand, so Chef has to buy some polybags to store these items.

1 polybag can contain at most 10 items. What is the minimum number of polybags needed by Chef?

The first line will contain an integer T - number of test cases. Then the test cases follow.

The first and only line of each test case contains an integer N - the number of items bought by Chef.

For each test case, output the minimum number of polybags required.

Constraints

1≤T≤1000

1≤N≤1000

Sample Input 1

3
20
24
99

Sample Output 1

2
3
10

 */
public class PolyBag {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(Double.valueOf(Math.ceil(n / 10D)).intValue());
      ++c;
    }

  }

}
