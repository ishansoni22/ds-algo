package com.ishan.dsalgo.dp;

public class LCS {

  public static void main(String[] args) {
    LCS lcs = new LCS();
    String s1 = "DAGX";
    String s2 = "BAGX";
    System.out.println(
        lcs.calculate(
            new Integer[s1.length()][s2.length()],
            s1,
            s2,
            s1.length(),
            s2.length()
        )
    );
  }

  private int calculate(Integer[][] memo, String s1, String s2, int s1Length, int s2Length) {
    if (s1Length == 0 || s2Length == 0) {
      return 0;
    }

    int s1Key = s1Length - 1;
    int s2Key = s2Length - 1;

    if (memo[s1Key][s2Key] != null) {
      return memo[s1Key][s2Key];
    } else if (s1.charAt(s1Key) == s2.charAt(s2Key)) {
      memo[s1Key][s2Key] = 1 + calculate(memo, s1, s2, s1Length - 1, s2Length - 1);
    } else {
      memo[s1Key][s2Key] = Math.max(
          calculate(memo, s1, s2, s1Length - 1, s2Length),
          calculate(memo, s1, s2, s1Length, s2Length - 1)
      );
    }
    return memo[s1Key][s2Key];
  }

}