package leetcode.p0001;

import java.util.*;

public class Program {
    public static void test(int[] nums, int target, int[] expected) {
        var solution = new Solution();
        var actualSet = new HashSet<Integer>();
        var expectedSet = new HashSet<Integer>();

        int[] actualArray = solution.twoSum(nums, target);

        assert actualArray != null;

        for (int i : actualArray) {
            actualSet.add(i);
        }

        for (int i : expected) {
            expectedSet.add(i);
        }

        if (!actualSet.equals(expectedSet)) {
            System.out.printf(
                    "numbers = %s, expected = %s, actual = %s\n",
                    Arrays.toString(nums), Arrays.toString(expected), Arrays.toString(actualArray));
        }
    }

    public static void main(String[] args) {
        test(new int[] {2, 3, 4, 10}, 7, new int[] {1, 2});
        test(new int[] {3, 2, 4}, 6, new int[] {1, 2});
        test(new int[] {-1, -2, -3, -4, -5}, -8, new int[] {2, 4});
        test(new int[] {-1, 2, -3, 4, -6}, 3, new int[] {0, 3});
        test(new int[] {3, 3}, 6, new int[] {0, 1});
    }
}
