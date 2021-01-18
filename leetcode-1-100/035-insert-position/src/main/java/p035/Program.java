package p035;

import java.util.*;

public final class Program {
    /**
     * Test a given set of inputs
     *
     * @param numbers numbers to give to the solution
     * @param target target number
     * @param expected expected index
     */
    private static void test(int[] numbers, int target, int expected) {
        var solution = new Solution();
        int actual = solution.searchInsert(numbers, target);

        if (actual != expected) {
            System.out.printf(
                    "numbers = %s, target = %d, expected = %d, actual = %d\n",
                    Arrays.toString(numbers), target, expected, actual);
        }
    }

    public static void main(String[] args) {
        // given cases
        test(new int[] {1, 3, 5, 6}, 5, 2);
        test(new int[] {1, 3, 5, 6}, 2, 1);
        test(new int[] {1, 3, 5, 6}, 7, 4);
        test(new int[] {1, 3, 5, 6}, 0, 0);
        test(new int[] {1}, 0, 0);

        // edge cases
        test(new int[] {}, 0, 0);
    }
}
