import java.util.Arrays;

public class Program {
  public static void test(int[] input, int[] expected) {
    Solution solution = new Solution();
    int len = solution.removeDuplicates(input);

    if (len != expected.length) {
      System.out.printf("expected length %d, found %d\n", expected.length, len);
      return;
    }

    if (!Arrays.equals(input, expected)) {
      System.out.printf(
        "expected %s, found %s\n",
        Arrays.toString(expected),
        Arrays.toString(input));
    }
  }
  public static void main(String[] args) {
    test(new int[] { 1, 1, 2 }, new int[] { 1, 2 });
  }
}
