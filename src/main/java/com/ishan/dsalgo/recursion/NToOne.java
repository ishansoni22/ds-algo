package com.ishan.dsalgo.recursion;

//Tail recursive solution
public class NToOne {

  private int n;

  public NToOne(int n) {
    this.n = Math.abs(n);
  }

  private void printIt(int i) {
    if (i <= 0) {
      return;
    }

    System.out.println(i);
    printIt(i - 1);
  }

  void print() {
    printIt(n);
  }


  public static void main(String[] args) {
    NToOne nToOne = new NToOne(15);
    nToOne.print();
  }

}
