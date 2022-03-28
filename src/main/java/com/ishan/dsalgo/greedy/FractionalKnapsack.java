package com.ishan.dsalgo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsack {

  public double fill(Double capacity, List<Item> items) {
    Double value = 0D;
    Collections.sort(items);

    for (Item item : items) {
      if (capacity >= item.getWeight()) {
        value = value + item.getValue();
        capacity = capacity - item.getWeight();
      } else {
        double allowedWeight = capacity;
        value = value + allowedWeight * (item.getValue() / item.getWeight());
        capacity = 0D;
      }
    }
    return value;
  }

  public static void main(String[] args) {
    FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
    Double capacity = 70D;
    List<Item> items = new ArrayList<>();
    items.add(new Item(600, 50D)); //12
    items.add(new Item(500, 20D)); //25
    items.add(new Item(400, 30D)); //13
    fractionalKnapsack.fill(capacity, items);
  }

}
