package com.ishan.dsalgo.introduction.analysis;

public class SumOfAnArray {

  /**
   * Order of growth of this function? -> n
   * How? -> C1(sum = 0, find n, i = 0, return sum) + C2n(i++, arr[i], sum += arr[i]) + C3(n + 1)(i < n)
   * = C1 + C2n + C3n + C3
   * = C1 + n(C2 + C3) + C3
   * = C1 + nC4 + C3
   * Ignore leading constants and lower order terms
   * = n
   *
   * Here the exact order of growth is deterministic
   *
   * Here we can say the order of growth is Theta(n)
   *
   */
  public int sum1(int arr[]) {
    int sum = 0;
    int n = arr.length;
    for(int i = 0; i < n; i++) {
      sum += arr[i];
    }
    return sum;
  }

  /**
   * Business requirement: Return 0 if the no of elements in the array is odd
   * For this algorithm, you cannot say anything clearly about order of growth
   * In some cases, when n is odd, the order of growth is constant
   * In other cases, its n
   *
   * Therefore we categorise order of growth into 3 categories
   *
   * 1. Best Case (Bogus, Nobody cares)
   *
   * 2. Average Case (Would like to know, But impractical to do most of the time)
   *  - Impractical to calculate. If you know what inputs are expected(and with what frequency),
   *  - only then can you calculate the average case
   *  - Example, If we assume that the probability of both the array having even and odd elements is the same
   *  - Then, the average order of growth = n/2 or linear!
   *
   * 3. Worst Case (*)
   *
   * Here the exact order of growth is not known. Therefore we could say
   * The order of growth is Big O (n)
   * or Omega (1) [Nobody cares]
   *
   */
  public int sum2(int arr[]) {
    int sum = 0;
    int n = arr.length;

    if(n % 2 != 0) {
      return sum;
    }

    for(int i = 0; i < n; i++) {
      sum += arr[i];
    }
    return sum;
  }

}
