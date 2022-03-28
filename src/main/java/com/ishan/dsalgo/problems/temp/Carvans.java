package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

 You're given the maximum speed of N cars in the order they entered the long straight segment of a circuit.
 Overtaking on this circuit is not possible.
 Each car prefers to move at its maximum speed.
 If that's not possible because of the front car being slow, it might have to lower its speed.
 It still moves at the fastest possible speed while avoiding any collisions.
 For the purpose of this problem, you can assume that the straight segment is infinitely long.

 Count the number of cars which were moving at their maximum speed on the straight segment.

 The first line of the input contains a single integer T denoting the number of test cases to follow.
 Description of each test case contains 2 lines.
 The first of these lines contain a single integer N, the number of cars.
 The second line contains N space separated integers, denoting the maximum speed of the cars in the order they entered the long straight segment.

 For each test case, output a single line containing the number of cars which were moving at their maximum speed on the segment.

 */
public class Carvans {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int numberOfCars = Integer.parseInt(br.readLine());
      String[] maxSpeedOfCars = br.readLine().split(" ");
      int currentMaxSpeed = Integer.parseInt(maxSpeedOfCars[0]);
      int carsTravellingAtMaxSpeed = 1;

      for (int i = 1; i < numberOfCars; i++) {
        int currentCarMaxSpeed = Integer.parseInt(maxSpeedOfCars[i]);
        if (currentCarMaxSpeed <= currentMaxSpeed) {
          ++carsTravellingAtMaxSpeed;
        }
        currentMaxSpeed = Math.min(currentMaxSpeed, currentCarMaxSpeed);
      }
      System.out.println(carsTravellingAtMaxSpeed);
      ++c;
    }

  }

}
