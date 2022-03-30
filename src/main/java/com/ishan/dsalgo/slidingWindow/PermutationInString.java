package com.ishan.dsalgo.slidingWindow;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:

    1 <= s1.length, s2.length <= 104
    s1 and s2 consist of lowercase English letters
 */
public class PermutationInString {

  public boolean checkInclusion(String s1, String s2) {

    if (s1.length() > s2.length()) return false;

    int[] hash = new int[26];
    int left = 0;
    int right = s1.length();

    for (int i = left; i < right; i++) {
      hash[s1.charAt(i) - 'a']++;
      hash[s2.charAt(i) - 'a']--;
    }

    if (stableWindow(hash)) {
      return true;
    }

    for (; right < s2.length(); right++) {
      hash[s2.charAt(left++) - 'a']++;
      hash[s2.charAt(right) - 'a']--;
      if (stableWindow(hash)) {
        System.out.println("Permutation found between " + left + " and " + right);
        return true;
      }
    }

    return false;
  }

  private boolean stableWindow(int[] hash) {
    for (int i = 0; i < hash.length; i++) {
      if (hash[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    PermutationInString permutationInString = new PermutationInString();
    System.out.println(permutationInString.checkInclusion("ab", "a"));
  }

}
