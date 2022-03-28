package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
You are given a binary string S of length N.

You have to perform the following operation exactly once:

Select an index i (1≤i≤N) and delete Si from S. The remaining parts of S are concatenated in the same order.

How many distinct binary strings of length N−1 can you get after applying this operation?

The first line of input contains a single integer T - the number of test cases. The description of T test cases follow.

The first line of each test case contains N - the length of the binary string S.

The second line contains the binary string S.

For each test case, output the number of distinct binary strings that you can get after applying the operation exactly once.

Constraints

1≤T≤10pow(5)

2≤N≤10pow(5)

Sum of Ndoes not exceed 2⋅10pow(5)over all testcases.

Sample Input 1

3
3
100
4
1111
5
10110

Sample Output 1

2
1
4

 */
public class DistinctBinary {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int nc = 0;
      int l = Integer.parseInt(br.readLine());
      char[] arr = br.readLine().toCharArray();
      for (int i = 0; i < l - 1; i++) {
        if (arr[i] == arr[i + 1]) {
          ++nc;
        }
      }
      System.out.println(l - nc);
      ++c;
    }

  }

}
