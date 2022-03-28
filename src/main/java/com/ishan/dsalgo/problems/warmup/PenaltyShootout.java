package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Teams A and B are having a penalty shoot-out to decide the winner of their football match.
 Each team gets to take a shot N times, and the team with the higher number of scored goals at the end wins.
 If the number of goals scored during the shoot-out by each team turns out to be the same even after all 2N shots,
 then they stop and agree that the result is a draw.

 The two teams take shots alternately — team A shoots first, then team B shoots,
 then team A and so on until team B takes its N-th shot (at which point each team has taken exactly N shots).
 Even though all 2N shots are taken,
 the result of the shoot-out is often known earlier
 — e.g. if team A has already scored N−1 goals and team B has missed at least two shots, team A is definitely the winner.

 For each shot, you know whether it was a goal or a miss.
 You need to find the earliest moment when the winner is known — the smallest s(0≤s≤2N) such that after s shots,
 the result of the shoot-out (whether team A won,
 team B won or the match is drawn) would be known even if we did not know the results of the remaining 2N−s shots.

 The first line of the input contains a single integer T denoting the number of test cases.
 The description of T test cases follows.

 The first line of each test case contains a single integer N.
 The second line contains a string S with length 2⋅N, where for each valid i,
 the i-th character is '0' if the i-th shot was a miss or '1' if it was a goal.

 For each test case, print a single line containing one integer — the smallest s such that after s shots,
 the result of the shoot-out is known.

 */
public class PenaltyShootout {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int totalPenaltiesEach = Integer.parseInt(br.readLine());
      int scorea = 0;
      int remaininga = totalPenaltiesEach;
      int scoreb = 0;
      int remainingb = totalPenaltiesEach;
      String[] scores = br.readLine().split("");
      int earliest = 2 * totalPenaltiesEach;
      for (int i = 1; i <= 2 * totalPenaltiesEach; i++) {
        if (i % 2 != 0) {
          --remaininga;
          scorea += Integer.parseInt(scores[i - 1]);
        } else {
          --remainingb;
          scoreb += Integer.parseInt(scores[i - 1]);
        }

        int diff = scorea - scoreb;

        //can a catch up?
        if (diff < 0) {
          if (remaininga < Math.abs(diff)) {
            earliest = i;
            break;
          }
        } else if (diff > 0) { //can b catch up?
          if (remainingb < Math.abs(diff)) {
            earliest = i;
            break;
          }
        }

      }
      System.out.println(earliest);
      ++c;
    }

  }

}
