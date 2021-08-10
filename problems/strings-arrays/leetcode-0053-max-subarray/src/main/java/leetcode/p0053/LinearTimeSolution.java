package leetcode.p0053;

import java.util.*;

public class LinearTimeSolution {
    /**
     * Find the sums of **local** max sub arrays
     *
     * @param nums nums
     * @return a list of the sum of local max subarrays
     */
    private List<Integer> maxSubArrays(int[] nums) {
        int currentSum = 0;
        var segments = new ArrayList<Integer>();

        for (int num : nums) {
            // if the sum of a local sub array is already negative, then regardless of what this
            // number is. Starting a new sub array always gives a bigger sum.
            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += num;
            segments.add(currentSum);
        }

        return segments;
    }

    public int maxSubArray(int[] nums) {
        int best = nums[0];

        for (int segment : maxSubArrays(nums)) {
            best = Math.max(segment, best);
        }

        return best;
    }
}
