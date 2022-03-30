package com.ishan.dsalgo.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 typically using all the original letters exactly once.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:

    1 <= s.length, p.length <= 3 * 104
    s and p consist of lowercase English letters.

 */
public class AllAnagramsInString {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> anagrams = new ArrayList<>();

    if (p.length() > s.length()) {
      return anagrams;
    }

    int[] hash = new int[26];
    int left = 0;
    int right = p.length();

    for (int i = left; i < right; i++) {
      hash[p.charAt(i) - 'a']++;
      hash[s.charAt(i) - 'a']--;
    }

    if (isStableWindow(hash)) {
      anagrams.add(left);
    }

    for (; right < s.length(); right++) {
      hash[s.charAt(left++) - 'a']++;
      hash[s.charAt(right) - 'a']--;

      if (isStableWindow(hash)) {
        anagrams.add(left);
      }
    }

    return anagrams;
  }

  private boolean isStableWindow(int[] hash) {
    for (int i = 0; i < hash.length; i++) {
      if (hash[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    AllAnagramsInString a = new AllAnagramsInString();
    System.out.println(a.findAnagrams("cbaebabacd", "abc"));
  }

}
