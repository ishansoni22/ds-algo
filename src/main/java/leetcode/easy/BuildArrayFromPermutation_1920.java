package leetcode.easy;

public class BuildArrayFromPermutation_1920 {

  private int[] getPermutations(int[] num) {

    int length = num.length;
    int[] output = new int[num.length];

    for (int i = 0; i < length; i++) {
      output[i] = num[num[i]];
    }
    return output;
  }

  public static void main(String[] args) {
    BuildArrayFromPermutation_1920 obj = new BuildArrayFromPermutation_1920();
    int input[] = {0, 2, 1, 5, 3, 4};
    PrintUtil.printIntArray(obj.getPermutations(input));
  }

}
