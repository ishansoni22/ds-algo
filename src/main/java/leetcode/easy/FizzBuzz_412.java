package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {

  public List<String> fizzBuzz(int n) {
    List<String> output = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      String word = "";
      if (i % 3 == 0) word += "Fizz";
      if (i % 5 == 0) word += "Buzz";
      if (word.isEmpty()) word = String.valueOf(i);
      output.add(word);
    }
    return output;
  }

  public static void main(String[] args) {
    FizzBuzz_412 obj = new FizzBuzz_412();
    System.out.println(obj.fizzBuzz(15));
  }

}
