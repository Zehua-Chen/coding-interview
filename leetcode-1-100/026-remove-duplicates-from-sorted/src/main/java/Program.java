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

    public static void test(int[] input, int[] expected) {
        Solution solution = new Solution();
        int len = solution.removeDuplicates(input);

        if (len == 0 && expected == null) {
            return;
        }

        if (len != expected.length) {
            System.out.printf("expected length %d, found %d\n", expected.length, len);
            return;
        }

        if (!equals(input, expected, len)) {
            System.out.printf(
                    "expected %s, found %s\n", Arrays.toString(expected), Arrays.toString(input));
        }
    }

    public static void main(String[] args) {
        test(null, null);
        test(new int[] {}, new int[] {});
        test(new int[] {1}, new int[] {1});
        test(new int[] {1, 2}, new int[] {1, 2});
        test(new int[] {1, 1, 2}, new int[] {1, 2});
        test(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[] {0, 1, 2, 3, 4});
        test(new int[] {0, 0, 7, 7}, new int[] {0, 7});
    }
}
