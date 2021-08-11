package leetcode.p0055;

public class RecursiveSolution {
    private boolean canJump(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        int maxSteps = nums[index];

        for (int steps = 1; steps <= maxSteps; steps++) {
            if (canJump(nums, index + steps)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }
}
