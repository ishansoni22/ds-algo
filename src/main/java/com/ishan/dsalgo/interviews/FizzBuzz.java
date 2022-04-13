package com.ishan.dsalgo.interviews;

public class FizzBuzz {

  public static void main(String[] args) {
    FizzBuzz fb = new FizzBuzz();
    fb.print(100);
  }

  public void print(int n) {
    for (int i = 1; i <= n; i++) {
      String o = "";
      if (i % 3 == 0) {
        o += "Fizz";
      }
      if (i % 5 == 0) {
        o += "Buzz";
      }
      if (o.equals("")) {
        System.out.println(i);
      } else {
        System.out.println(o);
      }
    }
  }

}
