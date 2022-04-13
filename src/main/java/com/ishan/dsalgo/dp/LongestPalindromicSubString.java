package com.ishan.dsalgo.dp;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

 */
public class LongestPalindromicSubString {

  //Todo
  public String longestPalindrome(String s) {
    return null;
  }

  //Brute force solution is to find all substrings and then find the longest palindromic sub-string
  public String longestPalindromeBruteForce(String s) {
    String l = "";
    for (int i = 0; i < s.length(); i++) {
      String ss = "";
      for (int j = i; j < s.length(); j++) {
        ss += s.charAt(j);
        if (isPalindrome(ss)) {
          l = ss.length() > l.length() ? ss : l;
        }
      }
    }
    return l;
  }

  private boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      ++left;
      --right;
    }
    return true;
  }

  public static void main(String[] args) {
    LongestPalindromicSubString l = new LongestPalindromicSubString();
    System.out.println(l.longestPalindrome("cbbd"));
  }

}
