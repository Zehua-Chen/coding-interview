package p033;

public class Solution {
    /**
     * Given start and end index, find the center index
     *
     * <p>If length is even, find "before center"
     *
     * @param start the start index
     * @param end   the end index
     * @return the center index
     */
    private int center(int start, int end) {
        return (end - start) / 2 + start;
    }

    /**
     * Find the index of the smallest element in an rotated array
     *
     * @param nums  the rotated array to search
     * @param start the start index
     * @param end   the end index
     * @return the index of the smallest element
     */
    private int min(int[] nums, int start, int end) {
        if (start > end || start < 0 || end >= nums.length) {
            return -1;
        }

        if (start == end) {
            return start;
        }

        if (start == end - 1) {
            if (nums[start] < nums[end]) {
                return start;
            }

            return end;
        }

        int center = center(start, end);

        if (nums[start] > nums[center]) {
            return min(nums, start, center);
        }

        if (nums[center] > nums[nums.length - 1]) {
            return min(nums, center, end);
        }

        return start;
    }

    /**
     * Perform a binary search in a span of a sorted array (no rotation)
     *
     * @param nums   the array
     * @param target the target to search for
     * @param start  the start of the span
     * @param end    the end of the span
     * @return the found index
     */
    private int search(int[] nums, int target, int start, int end) {
        if (start > end || start < 0 || end >= nums.length) {
            return -1;
        }

        if (start == end) {
            if (nums[start] == target) {
                return start;
            }

            return -1;
        }

        if (start == end - 1) {
            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }

            return -1;
        }

        int center = center(start, end);

        if (target > nums[center]) {
            return search(nums, target, center, end);
        }

        if (target < nums[center]) {
            return search(nums, target, start, center);
        }

        if (target == nums[center]) {
            return center;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int min = min(nums, 0, nums.length - 1);
        assert min != -1;

        // Given that center could be 0 in [x] and [x, x]
        // would need to check beforeMin is >= 0 later on
        int beforeMin = min - 1;

        if (target == nums[min]) {
            return min;
        }

        if (beforeMin >= 0 && target == nums[beforeMin]) {
            return min - 1;
        }

        if (target > nums[min] && target <= nums[nums.length - 1]) {
            return search(nums, target, min, nums.length - 1);
        }

        if (beforeMin >= 0 && target < nums[beforeMin] && target >= nums[0]) {
            return search(nums, target, 0, min);
        }

        return -1;
    }
}
