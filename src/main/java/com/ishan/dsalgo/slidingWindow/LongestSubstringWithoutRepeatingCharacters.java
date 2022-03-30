package com.ishan.dsalgo.slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  //Brute Force!
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

  public int lengthOfLongestSubstring(String s) {
    int result = 0;
    int startWindow = 0;
    Set<Character> chars = new HashSet<>();

    for (int endWindow = 0; endWindow < s.length(); endWindow++) {
      if (chars.contains(s.charAt(endWindow))) {
        while (chars.contains(s.charAt(endWindow))) {
          chars.remove(s.charAt(startWindow++));
        }
      }
      chars.add(s.charAt(endWindow));
      result = Math.max(result, chars.size());
    }
    return result;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
    System.out.println(l.lengthOfLongestSubstring("dvdf"));
  }

}
