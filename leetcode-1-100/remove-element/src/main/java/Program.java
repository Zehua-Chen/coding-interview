import java.util.Arrays;

public class Program {
  public static boolean equals(int[] a, int[] b, int length) {
    for (int i = 0; i < length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }

  public static void test(int element, int[] values, int[] expected) {
    Solution solution = new Solution();
    int outputLength = solution.removeElement(values, element);

    if (outputLength != expected.length) {
      System.out.printf(
        "expected length %d, actual %d\n",
        expected.length,
        outputLength);

      return;
    }

    if (!equals(values, expected, outputLength)) {
      System.out.printf(
        "expected: %s, actual: %s\n",
        Arrays.toString(expected),
        Arrays.toString(values));
    }
  }

  public static void main(String[] args) {
    test(3, new int[] { 3, 2, 2, 3 }, new int[] { 2, 2 });
    test(2, new int[] { 3, 2, 2, 3 }, new int[] { 3, 3 });
    test(2, new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, new int[] { 0, 1, 3, 0, 4 });
  }
}
