package p033;

import java.util.*;

public class Program {
    public static void test(int[] nums, int target, int expected) {
        var solution = new Solution();
        int actual = solution.search(nums, target);

        if (actual != expected) {
            System.out.printf(
                    "nums = %s, target = %d, expected = %d, actual = %d",
                    Arrays.toString(nums), target, expected, actual);
        }
    }

    public static void main(String[] args) {
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4);
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1);
        test(new int[]{1}, 0, -1);
    }
}
