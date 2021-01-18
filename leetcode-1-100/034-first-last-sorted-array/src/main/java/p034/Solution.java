package p034;

/**
 * The overall idea of the solution is to use two binary searches, one that look for the start
 * edge of the target region and one that look for the end edge of the target region.
 * <p>
 * The binary searches are special in that they do not stop upon the first number discovered.
 * Instead, they would continue search left/right to find the edges
 */
public class Solution {
    /**
     * Result to use when the target region is not found
     */
    private static final int[] ERROR = new int[]{-1, -1};

    /**
     * Look for the start edge of the target region
     * @param nums the array to search in, must not be null
     * @param left left bound of the array
     * @param right right bound of the array
     * @param target the value which make up the number region in question
     * @return the start edge, if any. Otherwise, return null
     */
    private Integer start(int[] nums, int left, int right, int target) {
        assert nums != null;

        if (left > right) {
            return null;
        }

        // Consider left == 0, right == 1
        // Mid would be calculated as (1 - 0) / 2 + 0 = 0
        // left(0, 0) would complete
        // left(0, 1) would cause infinite recursion
        if (right - left == 1) {
            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            return null;
        }

        if (left == right) {
            if (nums[left] == target) {
                return left;
            }

            return null;
        }

        int mid = ((right - left) / 2) + left;

        if (nums[mid] > target) {
            return start(nums, left, mid, target);
        }

        if (nums[mid] < target) {
            return start(nums, mid, right, target);
        }

        Integer leftResult = start(nums, left, mid, target);
        Integer rightResult = start(nums, mid, right, target);

        // Prefer to use left, since we are looking for the left edge
        if (leftResult != null) {
            return leftResult;
        }

        return rightResult;
    }

    /**
     * Look for the end edge of the target region.
     *
     * This method only differs from `start` in that it prefers the right hand side result.
     * @param nums the array to search in, must not be null
     * @param left left bound of the array
     * @param right right bound of the array
     * @param target the value which make up the number region in question
     * @return the end edge, if any. Otherwise, return null
     */
    private Integer end(int[] nums, int left, int right, int target) {
        assert nums != null;

        if (left > right) {
            return null;
        }

        // Consider left == 0, right == 1
        // Mid would be calculated as (1 - 0) / 2 + 0 = 0
        // right(0, 0) would complete
        // right(0, 1) would cause infinite recursion
        if (right - left == 1) {
            if (nums[right] == target) {
                return right;
            }

            if (nums[left] == target) {
                return left;
            }

            return null;
        }

        if (left == right) {
            if (nums[left] == target) {
                return left;
            }

            return null;
        }

        int mid = ((right - left) / 2) + left;

        if (nums[mid] > target) {
            return end(nums, left, mid, target);
        }

        if (nums[mid] < target) {
            return end(nums, mid, right, target);
        }

        Integer leftResult = end(nums, left, mid, target);
        Integer rightResult = end(nums, mid, right, target);

        // Prefer to use right, since we are looking for the right edge
        if (rightResult != null) {
            return rightResult;
        }

        return leftResult;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return ERROR;
        }

        if (nums.length == 0) {
            return ERROR;
        }

        Integer start = start(nums, 0, nums.length - 1, target);
        Integer end = end(nums, 0, nums.length - 1, target);

        if (start == null && end == null) {
            return ERROR;
        } else if (start == null) {
            return ERROR;
        } else if (end == null) {
            return ERROR;
        }

        return new int[]{start, end};
    }
}
