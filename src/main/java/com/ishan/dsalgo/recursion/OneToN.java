package com.ishan.dsalgo.recursion;

//Tail recursive solution
public class OneToN {

  private int n;

  public OneToN(int n) {
    this.n = Math.abs(n);
  }

  private void printIt(int i) {
    if (i > n) {
      return;
    }

    System.out.println(i);
    printIt(i + 1);
  }

  void print() {
    printIt(1);
  }


  public static void main(String[] args) {
    OneToN oneToN = new OneToN(15);
    oneToN.print();
  }

}
