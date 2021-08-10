package leetcode.p0053;

/** Build on top of `LinearTimeSolution` */
public class LinearTimeConstantSpaceSolution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int prefix = 0;

        for (int num : nums) {
            if (prefix < 0) {
                prefix = 0;
            }

            prefix += num;
            best = Math.max(prefix, best);
        }

        return best;
    }
}
