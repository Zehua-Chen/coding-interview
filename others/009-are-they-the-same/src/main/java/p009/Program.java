package p009;

import java.util.Arrays;

public class Program {
    public static void test(int[] a, int[] b, boolean expected) {
        var solution = new Solution();
        boolean actual = solution.comp(a, b);

        if (actual != expected) {
            System.out.printf(
                    "a = %s, b = %s, expected = %b, actual = %b\n",
                    Arrays.toString(a), Arrays.toString(b), expected, actual);
        }
    }

    public static void main(String[] args) {
        test(new int[]{}, new int[]{}, true);
        test(new int[]{1, 2, 3}, new int[]{1, 4, 9}, true);
        test(new int[]{1, 2, 3}, new int[]{1, 4, 1}, false);

        test(
                new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361},
                true);

        test(
                new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361},
                false);

        test(
                new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361},
                false);
    }
}
