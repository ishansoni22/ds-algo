package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Chef is playing a variant of Blackjack,
where 3 numbers are drawn and each number lies between 1 and 10 (with both 1 and 10 inclusive).
Chef wins the game when the sum of these 3 numbers is exactly 21.

Given the first two numbers A and B, that have been drawn by Chef,
what should be 3-rd number that should be drawn by the Chef in order to win the game?

Note that it is possible that Chef cannot win the game, no matter what is the 3-rd number.
In such cases, report −1 as the answer.

The first line will contain an integer T - number of test cases. Then the test cases follow.

The first and only line of each test case contains two integers A and B - the first and second number drawn by the Chef.

For each testcase, output the 3 -rd number that should be drawn by the Chef in order to win the game.

Output −1 if it is not possible for the Chef to win the game.

Constraints

1≤T≤100

1≤A,B≤10

Sample Input 1

3
1 10
1 5
4 9

Sample Output 1

10
-1
8

 */
public class BlackJack {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {

      String[] n = br.readLine().split(" ");
      int r = 21 - (Integer.parseInt(n[0]) + Integer.parseInt(n[1]));
      if (r > 10) {
        System.out.println(-1);
      } else {
        System.out.println(r);
      }
      ++c;
    }

  }

}
