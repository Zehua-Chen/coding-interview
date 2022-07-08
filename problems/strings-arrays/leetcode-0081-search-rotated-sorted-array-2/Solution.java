import static java.lang.System.out;

// custom test cases
/*
[2,5,6,0,0,1,2]
5
[2,3,4,5,6,7,0,1]
1
[2]
2
[2]
3
[2,3]
2
[2,2]
2
[3,2]
2
[3,2]
4
[1,0,1,1,1]
0
[1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1]
2
[1,2,3]
1
[1,2,3]
10
[1,1,3,1,1]
2
*/
public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return false;
        }

        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // out.printf("start = %d, end = %d, mid = %d\n", start, end, mid);

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                // out.println("binary search not helpful");
                start++;
                continue;
            }

            // which array does pivot belong to.
            boolean pivotArray = existsInFirst(nums, start, nums[mid]);

            // which array does target belong to.
            boolean targetArray = existsInFirst(nums, start, target);

            // If pivot and target exist in different sorted arrays, recall that
            // xor is true when both operands are distinct
            if (pivotArray ^ targetArray) {
                if (pivotArray) {
                    // pivot in the first, target in the second
                    start = mid + 1;
                } else {
                    // target in the first, pivot in the second
                    end = mid - 1;
                }
            // If pivot and target exist in same sorted array
            } else {
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if we can reduce the search space in current binary search
     * space.
     */
    private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    /**
     * Returns true if element exists in first array, false if it exists in
     * second.
     */
    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        boolean search = solution.search(new int[] { 1, 1, 2, 3, -1, 0 }, 0);

        out.printf("search = %b\n", search);
    }
}
