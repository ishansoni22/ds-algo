package com.ishan.dsalgo.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CoinDisbursement {

  private PriorityQueue<Integer> coins = new PriorityQueue<>(Comparator.reverseOrder());

  public void addCoin(Integer coin) {
    coins.add(coin);
  }

  public Map<Integer, Integer> disburse(Integer amount) {
    Map<Integer, Integer> disbursement = new HashMap<>();
    Integer balance = amount;
    while (balance > 0 && !coins.isEmpty()) {
      Integer maxCoin = coins.poll();
      int noOfMaxCoins = balance / maxCoin;
      disbursement.put(maxCoin, noOfMaxCoins);
      balance = balance - (noOfMaxCoins * maxCoin);
    }
    return disbursement;
  }

  public static void main(String[] args) {
    CoinDisbursement coinDisbursement = new CoinDisbursement();
    coinDisbursement.addCoin(1);
    coinDisbursement.addCoin(2);
    coinDisbursement.addCoin(5);
    coinDisbursement.addCoin(10);
    System.out.println(coinDisbursement.disburse(1));
  }

}
