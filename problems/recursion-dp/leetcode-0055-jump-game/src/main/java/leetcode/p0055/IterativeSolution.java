package leetcode.p0055;

public class IterativeSolution {
    public boolean canJump(int[] nums) {
        var table = new boolean[nums.length];
        table[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxSteps = nums[i];
            var canReach = false;

            for (int steps = 1; steps <= maxSteps; steps++) {
                if (table[i + steps]) {
                    canReach = true;
                    break;
                }
            }

            table[i] = canReach;
        }

        return table[0];
    }
}
