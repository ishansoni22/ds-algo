package com.ishan.dsalgo.recursion;

import java.util.Collections;

class PatternGenerator {

  private String style;
  private int n;

  public PatternGenerator(String style, int n) {
    this.style = style;
    this.n = n;
  }

  public void print() {
    print(this.n);
  }

  private void print(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(String.join("", Collections.nCopies(n, style)));
    print(n - 1);
    System.out.println(String.join("", Collections.nCopies(n, style)));
  }

}

public class Pattern {

  public static void main(String[] args) {
    PatternGenerator pg = new PatternGenerator("*", 5);
    pg.print();
  }

}
