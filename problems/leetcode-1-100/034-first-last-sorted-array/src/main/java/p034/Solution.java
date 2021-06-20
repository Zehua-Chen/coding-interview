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
     * Which edge of the region are we looking for
     */
    private enum Edge {
        /**
         * Find start edge
         */
        START,
        /**
         * Find end edge
         */
        END
    }

    /**
     * Look for an edge of the target region
     *
     * @param nums   the array to search in, must not be null
     * @param left   left bound of the array
     * @param right  right bound of the array
     * @param target the value which make up the number region in question
     * @param edge   the edge to find
     * @return the start edge, if any. Otherwise, return null
     */
    private Integer search(int[] nums, int left, int right, int target, Edge edge) {
        assert nums != null;

        if (left > right) {
            return null;
        }

        // Consider left == 0, right == 1
        // Mid would be calculated as (1 - 0) / 2 + 0 = 0
        // left(0, 0) would complete
        // left(0, 1) would cause infinite recursion
        if (right - left == 1) {
            switch (edge) {
                case START -> {
                    if (nums[left] == target) {
                        return left;
                    }
                    if (nums[right] == target) {
                        return right;
                    }

                    return null;
                }
                case END -> {
                    if (nums[right] == target) {
                        return right;
                    }
                    if (nums[left] == target) {
                        return left;
                    }

                    return null;
                }
            }
        }

        if (left == right) {
            if (nums[left] == target) {
                return left;
            }

            return null;
        }

        int mid = ((right - left) / 2) + left;

        // When the target region is to the left
        if (nums[mid] > target) {
            return search(nums, left, mid, target, edge);
        }

        // When the target region is to the right
        if (nums[mid] < target) {
            return search(nums, mid, right, target, edge);
        }

        // When we have landed in the target region
        Integer leftResult = search(nums, left, mid, target, edge);
        Integer rightResult = search(nums, mid, right, target, edge);

        switch (edge) {
            case START -> {
                if (leftResult != null) {
                    return leftResult;
                }

                return rightResult;
            }
            case END -> {
                if (rightResult != null) {
                    return rightResult;
                }

                return leftResult;
            }
        }

        return null;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return ERROR;
        }

        if (nums.length == 0) {
            return ERROR;
        }

        Integer start = search(nums, 0, nums.length - 1, target, Edge.START);
        Integer end = search(nums, 0, nums.length - 1, target, Edge.END);

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
