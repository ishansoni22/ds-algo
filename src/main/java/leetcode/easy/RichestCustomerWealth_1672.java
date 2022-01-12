package leetcode.easy;

import java.util.Arrays;

public class RichestCustomerWealth_1672 {

  public int maxWealth(int[][] allAccounts) {

    int max = 0;

    for (int[] personAccounts : allAccounts) {
      int wealth = Arrays.stream(personAccounts).sum();
      if (wealth > max) {
        max = wealth;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    RichestCustomerWealth_1672 obj = new RichestCustomerWealth_1672();
    int[][] accounts = {{1, 2, 3}, {3, 2, 1}, {0, 1, 1}};
    System.out.println(obj.maxWealth(accounts));
  }

}
