package p006;

import java.util.Arrays;

public class Program {
    public static void test(int value, int[] expected) {
        var solution = new Solution();
        int[] actual = solution.find(value);

        if (expected == null) {
            if (actual != null) {
                System.out.printf(
                        "value = %d, actual = %s expected = null\n",
                        value, Arrays.toString(actual));
            }

            return;
        }

        if (!Arrays.equals(actual, expected)) {
            System.out.printf(
                    "value = %d, actual = %s, expected = %s\n",
                    value, Arrays.toString(actual), Arrays.toString(expected));
        }
    }

    public static void main(String[] args) {
        test(32, null);
        test(64, new int[]{2, 4, 8});
        test(12345, new int[]{3, 5, 823});

        System.out.println("stress test");

        test(93995509, null);
        test(390058573, null);
    }
}
