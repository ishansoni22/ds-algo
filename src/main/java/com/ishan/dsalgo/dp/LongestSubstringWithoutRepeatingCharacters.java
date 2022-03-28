package com.ishan.dsalgo.dp;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstringNaive(String s) {
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      List<Character> charList = new ArrayList<>();
      for (int j = i; j < s.length(); j++) {
        if (!charList.contains(s.charAt(j))) {
          charList.add(s.charAt(j));
        } else {
          break;
        }
      }
      if (charList.size() > max) {
        max = charList.size();
      }
    }
    return max;
  }

  //Kadane's Algorithm
  //Kadane's algorithm is an iterative DP algorithm!
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.equals("")) {
      return 0;
    }
    String current = s.substring(0, 1);
    String max = current;

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if (current.indexOf(c) == -1) {
        current = current + c;
      } else {
        current = current.substring(current.lastIndexOf(c) + 1) + c;
      }
      if (current.length() > max.length()) {
        max = current;
      }
    }
    return max.length();
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
    System.out.println(l.lengthOfLongestSubstring("dvdf"));
  }

}
