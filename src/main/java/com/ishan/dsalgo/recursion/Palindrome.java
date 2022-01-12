package com.ishan.dsalgo.recursion;

import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {

  public static boolean recursiveCheck(String string) {
    return check(string, 0, string.length() - 1);
  }

  private static boolean check(String string, int begin, int end) {
    if (begin == end || begin > end) {
      return true;
    }
    return string.charAt(begin) == string.charAt(end) && check(string, begin + 1, end - 1);
  }

  //Think about how can you break down this problem into sub problems (smaller problems)
  public static boolean uglyRecursiveCheck(String string) {
    List<Character> list = string
        .chars()
        .mapToObj(e -> (char) e)
        .collect(Collectors.toList());
    return uglyCheck(list);
  }

  private static boolean uglyCheck(List<Character> list) {
    if (list.size() <= 1) {
      return true;
    }
    boolean isPalindrome = list.get(0) == list.get(list.size() - 1);
    list.remove(0);
    list.remove(list.size() - 1);
    return isPalindrome && uglyCheck(list);
  }

  public static boolean nonRecursiveCheck(String string) {
    boolean isPalindrome = true;
    int length = string.length();

    for (int i = 0; i < length / 2; i++) {
      if (string.charAt(i) != string.charAt(length - i - 1)) {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }

  public static void main(String[] args) {
    //System.out.println(Palindrome.nonRecursiveCheck("racecar"));
    //System.out.println(Palindrome.uglyRecursiveCheck("mommom"));
    System.out.println(Palindrome.recursiveCheck("moom"));
  }

}
