package leetcode.p0046;

import java.util.*;

public class OptimalSolution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void permute(int[] nums, int start, List<List<Integer>> results) {
        // Observe that permutation follows the pattern: [a, children], where a is every number
        // currently free, and children is the permutation of every free number except a
        //
        // Divide the array into two segments, [frozen..., free...].
        // For each number in start..<nums.length, freeze it, and repeat the process for start + 1
        if (start == nums.length) {
            var result = new ArrayList<Integer>();

            for (int num : nums) {
                result.add(num);
            }

            results.add(result);
        }

        for (int i = start; i < nums.length; i++) {
            // Since recursion will be made with start + 1, numbers at start will be frozen in child
            // recursive calls
            swap(nums, start, i);
            permute(nums, start + 1, results);
            swap(nums, start, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        var results = new ArrayList<List<Integer>>();
        permute(nums, 0, results);

        return results;
    }
}
