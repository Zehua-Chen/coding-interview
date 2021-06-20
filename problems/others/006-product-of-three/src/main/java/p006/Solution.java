package p006;

import java.util.Set;

public class Solution {
    /**
     * Find minimum divisor for a given value such that after taking out the found divisor, there
     * are still divisors bigger than or equal to the found divisor
     *
     * @param value    the value in question
     * @param excludes numbers that we don't consider
     * @return the minimum divisor if there is one; -1 otherwise
     */
    private int findMinDivisor(int value, Set<Integer> excludes) {
        // if candidate * candidate <= value is reached and we still haven't had a divisor,
        // then even if there is a divisor beyond this candidate, the remaining divisors available
        // after taking out this potential divisor would be smaller than the potential divisor
        // which is not what we want
        for (int candidate = 1; candidate * candidate <= value; candidate++) {
            if ((value % candidate) != 0) {
                continue;
            }

            if (excludes.contains(candidate)) {
                continue;
            }

            return candidate;
        }

        return -1;
    }

    /**
     * Find three divisors for a value
     *
     * @param value the value in question
     * @return three divisors if there are, null otherwise
     */
    public int[] find(int value) {
        // Suppose a < b < c, Let's try to minimize a and maximize c; let a be the minimum divisor
        // of n greater than 1. Then let b be the minimum divisor of n / a, that isn't equal to
        // a and 1. If n / (a * b) is not equal to a, b, and 1, then the answer is yes,
        // otherwise, the answer is no
        //
        // Time complexity: O(sqrt (n))
        //
        // Source: http://codeforces.com/blog/entry/73274

        int a = findMinDivisor(value, Set.of(1));

        if (a == -1) {
            return null;
        }

        int b = findMinDivisor(value / a, Set.of(a, 1));

        if (b == -1) {
            return null;
        }

        int c = value / (a * b);

        if (c != a && c != b && c != 1) {
            return new int[]{a, b, c};
        }

        return null;
    }
}
