package leetcode.p0045;

public class Solution {
    public int jump(int[] nums) {
        var jumps = new int[nums.length + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= nums.length - 1) {
                jumps[i] = 0;
                continue;
            }

            int max = nums[i];

            if (max == 0) {
                jumps[i] = -1;
                continue;
            }

            int best = Integer.MAX_VALUE;

            for (int j = 1; j <= max; j++) {
                if (i + j >= nums.length) {
                    continue;
                }

                int candidate = jumps[i + j] + 1;

                if (jumps[i + j] == -1) {
                    continue;
                }

                if (candidate < best) {
                    best = candidate;
                }
            }

            if (best == Integer.MAX_VALUE) {
                best = -1;
            }

            jumps[i] = best;
        }

        return jumps[0];
    }
}
