package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 Given three distinct integers A, B and C, print the second largest number among them.

 The input consists of three lines.
 The first line contains a single integer A.
 The second line contains a single integer B.
 The third line contains a single integer C.

 Print the second largest number among A, B and C, in a separate line.
 */
public class SecondLargest {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
    q.add(Integer.parseInt(br.readLine()));
    q.add(Integer.parseInt(br.readLine()));
    q.add(Integer.parseInt(br.readLine()));

    q.poll();
    System.out.println(q.poll());

  }

}
