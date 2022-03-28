package com.ishan.dsalgo.problems.warmup;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:

Input: s = "God Ding"
Output: "doG gniD"

 */
public class ReverseWordsInString3 {

  public String reverseWords(String s) {
    char[] charArr = s.toCharArray();
    String[] words = s.split(" ");

    int startIdx = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      reverse(charArr, startIdx, startIdx + word.length() - 1);
      startIdx = startIdx + word.length() + 1;
    }

    return new String(charArr);
  }

  private void reverse(char[] charArr, int startIdx, int endIdx) {
    while (startIdx < endIdx) {
      char temp = charArr[startIdx];
      charArr[startIdx] = charArr[endIdx];
      charArr[endIdx] = temp;
      ++startIdx;
      --endIdx;
    }
  }

  public String reverseWordsNaive(String s) {
    String[] words = s.split(" ");

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      sb.append(reverseNaive(word));
      if (i != words.length - 1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  private String reverseNaive(String word) {
    char[] wordArray = word.toCharArray();
    for (int i = 0; i < wordArray.length / 2; i++) {
      char temp = wordArray[i];
      wordArray[i] = wordArray[wordArray.length - i - 1];
      wordArray[wordArray.length - i - 1] = temp;
    }
    return new String(wordArray);
  }

  public static void main(String[] args) {
    ReverseWordsInString3 r = new ReverseWordsInString3();
    System.out.println(r.reverseWords("Let's take LeetCode contest"));
  }

}
