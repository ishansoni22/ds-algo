package com.ishan.dsalgo.arrays;

import java.util.Objects;

public class LargestNumber {

  private Integer[] array;

  public LargestNumber(Integer[] array) {
    this.array = array;
  }

  public Integer largest() {
    if (Objects.isNull(array) || array.length == 0) {
      return null;
    }
    Integer largest = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > largest) {
        largest = array[i];
      }
    }
    return largest;
  }

  public static void main(String[] args) {
    Integer[] array = {5, 67, 125, 4, 17, 67, 102, 250, 250};
    LargestNumber lr = new LargestNumber(array);
    System.out.println(lr.largest());
  }

}
