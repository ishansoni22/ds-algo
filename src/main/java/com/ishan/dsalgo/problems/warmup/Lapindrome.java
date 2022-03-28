package com.ishan.dsalgo.problems.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 Lapindrome is defined as a string which when split in the middle,
 gives two halves having the same characters and same frequency of each character.
 If there are odd number of characters in the string, we ignore the middle character and check for lapindrome.
 For example gaga is a lapindrome, since the two halves ga and ga have the same characters with same frequency.
 Also, abccab, rotor and xyzxy are a few examples of lapindromes.
 Note that abbaab is NOT a lapindrome. The two halves contain the same characters but their frequencies do not match.
 Your task is simple. Given a string, you need to tell if it is a lapindrome.

 First line of input contains a single integer T, the number of test cases.
 Each test is a single line containing a string S composed of only lowercase English alphabet.

 For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.

 */
public class Lapindrome {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            System.in
        )
    );

    int t = Integer.parseInt(br.readLine());
    int c = 0;

    while (c < t) {
      String isLapindrome = "YES";
      String string = br.readLine();
      int length = string.length();
      int middle = length / 2;
      String firstHalf = string.substring(0, middle);
      if (length % 2 != 0) {
        middle = middle + 1;
      }
      String secondHalf = string.substring(middle, length);

      Map<Character, Integer> frequencyMap = new HashMap<>();
      for (int i = 0; i < firstHalf.length(); i++) {
        char ch = firstHalf.charAt(i);
        if (frequencyMap.containsKey(ch)) {
          frequencyMap.put(ch, frequencyMap.get(ch) + 1);
        } else {
          frequencyMap.put(ch, 1);
        }
      }

      for (int i = 0; i < secondHalf.length(); i++) {
        char ch = secondHalf.charAt(i);
        if (frequencyMap.containsKey(ch)) {
          Integer v = frequencyMap.get(ch);
          if (v == 1) {
            frequencyMap.remove(ch);
          } else {
            frequencyMap.put(ch, v - 1);
          }
        } else {
          isLapindrome = "NO";
          break;
        }
      }
      if (!frequencyMap.isEmpty()) {
        isLapindrome = "NO";
      }
      System.out.println(isLapindrome);
      ++c;
    }

  }

}
