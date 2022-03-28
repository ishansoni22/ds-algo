package com.ishan.dsalgo.problems.warmup;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordsString_151 {

  public String reverse(String s) {
    Deque<String> deque = new ArrayDeque<>();

    for (String str : s.split(" ")) {
      if (!str.isEmpty()) {
        deque.push(str);
      }
    }

    StringBuilder builder = new StringBuilder();
    while (!deque.isEmpty()) {
      builder.append(deque.pop()).append(" ");
    }

    return builder.toString().trim();
  }

  public static void main(String[] args) {
    ReverseWordsString_151 obj = new ReverseWordsString_151();
    System.out.println(obj.reverse("                Bob    Loves           Alice   "));
  }

}
