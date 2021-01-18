package p034;

import java.util.*;

public class Program {
    public static void test(int[] nums, int target, int[] expected) {
        var solution = new Solution();
        int[] actual = solution.searchRange(nums, target);

        assert actual != null;

        if (!Arrays.equals(actual, expected)) {
            System.out.printf(
                    "nums = %s, target = %d, actual = %s, expected = %s",
                    Arrays.toString(nums),
                    target,
                    Arrays.toString(actual),
                    Arrays.toString(expected));
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3}, 2, new int[]{1, 1});
        test(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4});
        test(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1});
        test(new int[]{}, 0, new int[]{-1, -1});
    }
}
