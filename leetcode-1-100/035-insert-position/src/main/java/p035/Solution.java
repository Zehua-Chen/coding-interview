package p035;

/**
 * Basically a binary search algorithm, but with more cases to look for insertion points when
 * the target is not found.
 */
public final class Solution {
    /**
     * Find within a region
     * @param nums the numbers in question
     * @param target the target to look for
     * @param left left index of the region
     * @param right right index of the region
     * @return either the index at which target can be found, or at which the target can be inserted
     */
    private int search(int[] nums, int target, int left, int right) {
        // Base cases
        if (left == right) {
            // Found
            if (nums[left] == target) {
                return left;
            }

            // Two possible points of insertion
            // 1. to the left
            // 2. to the right

            // Insert to the left
            if (nums[left] > target) {
                return left;
            }

            // Insert to the right
            return left + 1;
        }

        if ((right - left) == 1) {
            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            // Three possible points of insertion
            // 1. to the left of left
            // 2. to the right of left and left of right, i.e. in between
            // 3. to the right of right

            // Insert in between left and right
            if (nums[left] < target && nums[right] > target) {
                return left + 1;
            }

            // Insert to the left of left
            if (nums[left] > target) {
                return left;
            }

            // Insert to the right of right
            return right + 1;
        }

        int mid = ((right - left) / 2) + left;

        // Equivalent cases

        if (nums[left] == target) {
            return left;
        }

        if (nums[right] == target) {
            return right;
        }

        if (nums[mid] == target) {
            return mid;
        }

        // In between (left, right) regions recursive cases

        if (nums[left] < target && target < nums[mid]) {
            return search(nums, target, left, mid);
        }

        if (target > nums[mid] && target < nums[right]) {
            return search(nums, target, mid, right);
        }

        // Equivalent cases and in between (left, right) cases have been checked up to this point
        // 2 possible points of insertion remains
        // 1. left of the (left, right) region
        // 2. right of the (left, right) region

        if (nums[left] > target) {
            return left;
        }

        return right + 1;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return search(nums, target, 0, nums.length - 1);
    }
}
