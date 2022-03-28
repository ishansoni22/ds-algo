package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Chef went shopping and bought items worth X rupees (1≤X≤100). Unfortunately, Chef only has a single 100 rupees note.

Since Chef is weak at maths,
can you help Chef in calculating what money he should get back after paying 100 rupees for those items?

First line will contain T, the number of test cases. Then the test cases follow.

Each test case consists of a single line containing an integer X, the total price of items Chef purchased.

Output Format

For each test case, output in a single line the money Chef has to receive back.

Constraints

1≤T≤100

1≤X≤100

Sample Input 1

3
1
25
100

Sample Output 1

99
75
0

 */
public class ChefChange {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int p = Integer.parseInt(br.readLine());
      System.out.println(100 - p);
      ++c;
    }
  }

}
