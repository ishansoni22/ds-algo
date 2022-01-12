package com.ishan.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;

public class RopeCuttingProblem {

  /**
   * Try to draw the recursion tree for a recursive solution. The leaves of the recursion tree tell
   * you the base cases
   */
  private int length;
  private int a;
  private int b;
  private int c;
  private List<List<Integer>> validCuts = new ArrayList<>();

  public RopeCuttingProblem(int length, int a, int b, int c) {
    this.length = length;
    this.a = a;
    this.b = b;
    this.c = c;
    cut(this.length, new ArrayList<>());
  }

  private void cut(int length, List<Integer> pieces) {
    if (length == 0) {
      //valid cut
      validCuts.add(pieces);
      return;
    }
    if (length > 0) {
      List<Integer> aCut = new ArrayList<>(pieces);
      aCut.add(a);
      cut(length - a, aCut);

      List<Integer> bCut = new ArrayList<>(pieces);
      bCut.add(b);
      cut(length - b, bCut);

      List<Integer> cCut = new ArrayList<>(pieces);
      cCut.add(c);
      cut(length - c, cCut);
    }

  }

  public List<List<Integer>> getValidCuts() {
    return validCuts;
  }

  public static void main(String[] args) {
    RopeCuttingProblem rcp = new RopeCuttingProblem(9, 2, 4, 3);
    System.out.println(rcp.getValidCuts());
  }

}
