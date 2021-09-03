package leetcode.p0060;

import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        var digits = new ArrayList<Integer>();
        var factorial = new ArrayList<Integer>();
        var result = new StringBuilder();

        // k is 1-based
        k--;

        // 0! = 1
        factorial.add(1);

        for (int i = 1; i < n; i++) {
            factorial.add(i * factorial.get(i - 1));
        }

        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }

        for (; n >= 1; n--) {
            int size = factorial.get(n - 1);
            int digitIndex = k / size;
            k %= size;

            result.append(digits.get(digitIndex));
            digits.remove(digitIndex);
        }

        return result.toString();
    }
}
