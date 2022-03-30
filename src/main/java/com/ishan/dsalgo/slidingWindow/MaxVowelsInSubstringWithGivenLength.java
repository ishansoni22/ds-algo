package com.ishan.dsalgo.slidingWindow;

/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

 */
public class MaxVowelsInSubstringWithGivenLength {

  public int maxVowels(String s, int k) {
    int max = 0;
    if (s.length() < k) {
      return max;
    }

    //Initial Window [left, right)
    int left = 0;
    int right = k;

    int[] hash = new int[26];

    for (int i = left; i < right; i++) {
      hash[s.charAt(i) - 'a']++;
    }

    max = Math.max(max, countVowels(hash));

    for (; right < s.length(); right++) {
      hash[s.charAt(left++) - 'a']--;
      hash[s.charAt(right) - 'a']++;

      max = Math.max(max, countVowels(hash));
    }

    return max;
  }

  private int countVowels(int[] hash) {
    return hash[0] + hash[4] + hash[8] + hash[14] + hash[20];
  }

}
