package com.ishan.dsalgo.greedy;

import java.util.Objects;

public class Item implements Comparable<Item> {

  private Integer value;
  private Double weight;

  public Item(Integer value, Double weight) {
    this.value = Objects.requireNonNull(value);
    this.weight = Objects.requireNonNull(weight);
  }

  public Integer getValue() {
    return value;
  }

  public Double getWeight() {
    return weight;
  }

  public Double getValuePerWeightUnit() {
    return getValue() / getWeight();
  }

  @Override
  public int compareTo(Item o) {
    return o.getValuePerWeightUnit().compareTo(getValuePerWeightUnit());
  }

}
