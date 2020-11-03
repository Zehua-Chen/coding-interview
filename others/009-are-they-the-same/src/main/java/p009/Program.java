package p009;

import java.util.Arrays;

public class Program {
    public static void test(int[] as, int[] bs, boolean expected) {
        var solution = new Solution();
        boolean actual = solution.comp(as, bs);

        if (actual != expected) {
            System.out.printf(
                    "as = %s, bs = %s, expected = %b, actual = %b\n",
                    Arrays.toString(as), Arrays.toString(bs), expected, actual);
        }
    }

    public static void main(String[] args) {
        test(new int[]{}, new int[]{}, true);
        test(new int[]{1, 2}, new int[]{}, false);
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
