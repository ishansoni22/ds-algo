package com.ishan.dsalgo.problems.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 In Chefland, there is a very famous street where N types of street food (numbered 1 through N) are offered.
 For each valid i, there are Si stores that offer food of the i-th type,
 the price of one piece of food of this type is Vi (the same in each of these stores) and each day,
 Pi people come to buy it; each of these people wants to buy one piece of food of the i-th type.

 Chef is planning to open a new store at this street, where he would offer food of one of these N types.
 Chef assumes that the people who want to buy the type of food he'd offer will split equally among all stores that offer it,
 and if this is impossible, i.e. the number of these people p is not divisible by the number of these stores s,
 then only ⌊p/s⌋ people will buy food from Chef.

 Chef wants to maximise his daily profit.
 Help Chef choose which type of food to offer and find the maximum daily profit he can make.

 The first line of the input contains a single integer T denoting the number of test cases.
 The description of T test cases follows.
 The first line of each test case contains a single integer N.
 N lines follow. For each i (1≤i≤N), the i-th of these lines contains three space-separated integers Si, Pi and Vi

 For each test case, print a single line containing one integer ― the maximum profit.
 */
public class ChefLand {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int t = Integer.parseInt(br.readLine());

    while (c < t) {
      int foodItems = Integer.parseInt(br.readLine());
      int maximumProfit = 0;
      for (int i = 0; i < foodItems; i++) {
        String[] foodItem = br.readLine().split(" ");
        int foodItemProfit = Integer.parseInt(foodItem[2]) * (Integer.parseInt(foodItem[1]) / (
            Integer.parseInt(foodItem[0]) + 1));
        if (foodItemProfit > maximumProfit) {
          maximumProfit = foodItemProfit;
        }

      }
      System.out.println(maximumProfit);
      ++c;
    }

  }

}
