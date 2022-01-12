package leetcode.easy;

import java.util.Arrays;

public class PrintUtil {

  public static void printIntArray(int[] arr) {
    Arrays.stream(arr)
        .forEach(System.out::println);
  }

  public static void printArray(Object[] arr) {
    Arrays.stream(arr)
        .forEach(System.out::println);
  }

}
