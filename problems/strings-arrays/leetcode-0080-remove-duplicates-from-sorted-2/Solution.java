public class Solution {
    // edge cases
    // [1]
    // [1,1,1,1,1]
    // [1,2,3,4,5]
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int read = 0;

        int current = nums[read];
        int currentCount = 0;

        for (; read < nums.length; read++) {
            int num = nums[read];

            if (num != current) {
                current = nums[read];
                currentCount = 0;
            }

            if (currentCount == 2) {
                continue;
            }

            currentCount++;
            nums[write] = num;
            write++;
        }

        return write;
    }
}
