package com.ishan.dsalgo.problems.warmup;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

 */
public class ValidAnagram {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] hash = new int[26];

    for (int i = 0; i < s.length(); i++) {
      hash[s.charAt(i) - 'a']++;
      hash[t.charAt(i) - 'a']--;
    }

    return checkAnagram(hash);
  }

  private boolean checkAnagram(int[] hash) {
    for (int i = 0; i < hash.length; i++) {
      if (hash[i] != 0) {
        return false;
      }
    }
    return true;
  }

}
