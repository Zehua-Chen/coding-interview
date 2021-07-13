package leetcode.p0041;

public class Solution {
    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    private int movePositivesToFront(int[] nums) {
        int swapIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                swap(nums, i, swapIndex);
                swapIndex++;
            }
        }

        return swapIndex;
    }

    private int firstMissingPositive(int[] nums, int size) {
        // The naive approach will be to put elements of nums into a hash set. Then start to try
        // from 1, if the tried number is not in hash set, return the number
        //
        // Here, we simulate a hash set using the array. Where the (number - 1) is the number,
        // nums[number - 1] == true means the number is present, and nums[number - 1] == false
        // means the number is not present.
        for (int i = 0; i < size; i++) {
            int original = Math.abs(nums[i]);
            int index = original - 1;

            // There is no need to test numbers that are too large.
            // 1. If nums is made of entirely numbers that are small enough, then the result
            //    comes from 1, numbers in this range, or size + 1
            // 2. If ... small numbers and big numbers, then the result is from 1, the range
            //    of small numbers, or size + 1
            // 3. If ... big numbers, then the result is 1
            if (index >= size) {
                continue;
            }

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < size; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return size + 1;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        int size = movePositivesToFront(nums);
        return firstMissingPositive(nums, size);
    }
}
