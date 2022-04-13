package com.ishan.dsalgo.backtracking;

/*
Given a length l (longest possible length of somebody's password),
 try all possible alphanumeric passwords till you are able to login
 */

//Todo - How is this a backtracking problem?
//Todo - Can this be converted to something like this - https://leetcode.com/problems/subsets/solution/
public class CrackPassword {

  //---------- Variation - Return the password

  public String crackPassword(int length) {
    return cp("", length);
  }

  private String cp(String currentPassword, int length) {
    if (login(currentPassword)) {
      return currentPassword;
    } else if (currentPassword.length() == length) {
      return "";
    }

    for (int i = 33; i <= 122; i++) {
      String password = cp(currentPassword + (char) i, length);
      if (password != "") {
        //Found the password (Do not try the other combinations
        // - Return as soon as you find one option - But is this backtracking?)
        return password;
      }
    }
    return "";
  }

  //----------

  public boolean crack(int length) {
    return c("", length);
  }

  private boolean c(String currentPassword, int length) {
    if (currentPassword.length() > length) {
      return false;
    } else if (login(currentPassword)) {
      System.out.println("Cracked Password: " + currentPassword);
      return true;
    }

    boolean cracked = false;

    for (int i = 33; i <= 122; i++) {
      cracked = cracked || c(currentPassword + (char) i, length);
    }
    return cracked;
  }

  boolean login(String password) {
    System.out.println("Trying..." + password);
    if (password.equals("AB")) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    CrackPassword c = new CrackPassword();
    System.out.println(c.crackPassword(2));
  }

}
