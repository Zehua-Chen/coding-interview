package leetcode.p0001;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // a map from numbers to their indices in the array
        var indices = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        for (var i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (indices.containsKey(diff) && indices.get(diff) != i) {
                return new int[] {i, indices.get(diff)};
            }
        }

        return new int[] {0, 0};
    }
}
