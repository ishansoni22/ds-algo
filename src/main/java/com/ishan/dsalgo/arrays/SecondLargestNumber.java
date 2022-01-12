package com.ishan.dsalgo.arrays;

import java.util.Objects;

public class SecondLargestNumber {

  private Integer[] array;

  public SecondLargestNumber(Integer[] array) {
    this.array = array;
  }

  public Integer secondLargest() {

    if (Objects.isNull(array) || array.length == 0) {
      return null;
    }

    Integer largest = array[0];
    Integer secondLargest = null;

    for (int i = 1; i < array.length; i++) {

      if (array[i].equals(largest)) {

      } else if (array[i] > largest) {
        secondLargest = largest;
        largest = array[i];
      } else {
        if (Objects.isNull(secondLargest)) {
          secondLargest = array[i];
        } else if (array[i] > secondLargest) {
          secondLargest = array[i];
        }
      }

    }

    return secondLargest;

  }

  public static void main(String[] args) {
    Integer[] array = {10, 10, 10, 5};
    SecondLargestNumber sl = new SecondLargestNumber(array);
    System.out.println(sl.secondLargest());
  }

}
