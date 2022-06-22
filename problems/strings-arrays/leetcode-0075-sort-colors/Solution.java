public class Solution {
    private int write(int[] nums, int start, int count, int value) {
        while (count > 0) {
            nums[start++] = value;
            count--;
        }

        return start;
    }

    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else if (nums[i] == 2) {
                count2++;
            }
        }

        int i = 0;

        i = write(nums, i, count0, 0);
        i = write(nums, i, count1, 1);
        i = write(nums, i, count2, 2);
    }
}
