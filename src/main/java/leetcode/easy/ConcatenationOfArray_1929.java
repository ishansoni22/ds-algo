package leetcode.easy;

public class ConcatenationOfArray_1929 {

  public int[] concatenate(int[] nums) {
    int length = nums.length;
    int[] output = new int[length * 2];

    for (int i = 0; i < length; i++) {
      int num = nums[i];
      output[i] = num;
      output[length + i] = num;
    }
    return output;
  }

  public static void main(String[] args) {
    ConcatenationOfArray_1929 obj = new ConcatenationOfArray_1929();
    int input[] = {1, 3, 2, 1};
    PrintUtil.printIntArray(obj.concatenate(input));
  }

}
