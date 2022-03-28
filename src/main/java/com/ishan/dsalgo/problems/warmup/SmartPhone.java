package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 You are developing a smartphone app. You have a list of potential customers for your app.
 Each customer has a budget and will buy the app at your declared price if and only if the price is less than or equal to the customer's budget.

 You want to fix a price so that the revenue you earn from the app is maximized.
 Find this maximum possible revenue.

 For instance, suppose you have 4 potential customers and their budgets are 30, 20, 53 and 14.
 In this case, the maximum revenue you can get is 60.

 Line 1 : N, the total number of potential customers.

 Lines 2 to N+1: Each line has the budget of a potential customer.

 The output consists of a single integer, the maximum possible revenue you can earn from selling your app.

 */
public class SmartPhone {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int c = 0;
    int NumberOfCustomers = Integer.parseInt(br.readLine());
    Long[] customerBudget = new Long[NumberOfCustomers];
    long maxProfit = 0;

    while (c < NumberOfCustomers) {
      customerBudget[c] = Long.parseLong(br.readLine());
      ++c;
    }

    Arrays.sort(customerBudget);

    for (int i = 0; i < customerBudget.length; i++) {
      long profit = customerBudget[i] * (customerBudget.length - i);
      if (profit > maxProfit) {
        maxProfit = profit;
      }
    }

    System.out.print(maxProfit);
  }

}
