package com.ishan.dsalgo.interviews;

public class Counter {

  private static int COUNT = 0;

  public Counter() {
    ++COUNT;
  }

  public static int getCount() {
    return Counter.COUNT;
  }

  public static void main(String[] args) {
    Counter counter1 = new Counter();
    Counter counter2 = new Counter();

    System.out.println(Counter.getCount());
  }

}
