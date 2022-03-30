package com.ishan.dsalgo.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/*
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
The only good substring of length 3 is "xyz".

Example 2:

Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".

 */
public class SubStringsOfSizeThreeWithDistinctElements {

  //Brute Force!
  public int countGoodSubstringsNaive(String s) {
    int count = 0;
    for (int i = 0; i < s.length() - 2; i++) {
      Set<Character> hash = new HashSet<>();
      if (hash.add(s.charAt(i))
          && hash.add(s.charAt(i + 1))
          && hash.add(s.charAt(i + 2))) {
        count++;
      }
    }
    return count;
  }

  public int countGoodSubstrings(String s) {
    int count = 0;
    if (s.length() < 3) {
      return count;
    }

    int[] hash = new int[26];

    //[left, right)
    int left = 0;
    int right = 3;

    for (int i = left; i < right; i++) {
      hash[s.charAt(i) - 'a']++;
    }

    if (isGoodSubString(hash)) {
      ++count;
    }

    for (; right < s.length(); right++) {
      hash[s.charAt(left++) - 'a']--;
      hash[s.charAt(right) - 'a']++;
      if (isGoodSubString(hash)) {
        count++;
      }
    }

    return count;
  }

  private boolean isGoodSubString(int[] hash) {
    int oneCount = 0;
    for (int i = 0; i < hash.length; i++) {
      if (hash[i] == 0 || hash[i] == 1) {
        oneCount += hash[i];
      } else {
        return false;
      }
    }
    return oneCount == 3;
  }

  public static void main(String[] args) {
    SubStringsOfSizeThreeWithDistinctElements s = new SubStringsOfSizeThreeWithDistinctElements();
    System.out.println(s.countGoodSubstrings("aababcabc"));
  }

}
