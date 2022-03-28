package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

Given two positive numbers B and C, what is the minimum positive value of A, such that A⋅B is divisible by C.

Here, A⋅B denotes the value obtained when A is multiplied by B.

The first line will contain an integer T - number of test cases. Then the test cases follow.
The first and only line of each test case contains two integers B and C.

For each test case, output the minimum value of A such that A⋅B is divisible by C.

Constraints
1 ≤ T ≤ 10pow(5)
1 ≤ B,C ≤ 10pow(9)

Sample Input 1

2
2 4
8 12

Sample Output 1

2
3

 */
public class ProductMystery {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int count = 0;
    int t = Integer.parseInt(br.readLine());

    while (count < t) {
      String[] i = br.readLine().split(" ");
      long b = Long.parseLong(i[0]);
      long c = Long.parseLong(i[1]);

      long gcd = -1;
      while (gcd != 1) {
        gcd = findGCD(b, c);
        b = b / gcd;
        c = c / gcd;
      }
      System.out.println(c);
      ++count;
    }

  }

  static long findGCD(long x, long y) {
    long r = 0;
    long a = 0;
    long b = 0;
    a = (x > y) ? x : y;
    b = (x < y) ? x : y;
    r = b;
    while (a % b != 0) {
      r = a % b;
      a = b;
      b = r;
    }
    return r;
  }

}
