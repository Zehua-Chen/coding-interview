package leetcode.p0047;

import java.util.*;

public class Solution {
    private void permute(
            Map<Integer, Integer> counts,
            int nums,
            List<Integer> result,
            List<List<Integer>> results) {
        // Think of the solution as one made for general permutation, but we treat all the
        // occurances of a unique number as a number.
        if (result.size() == nums) {
            results.add(new ArrayList<>(result));
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();

            if (count == 0) {
                continue;
            }

            int number = entry.getKey();

            counts.put(number, count - 1);
            result.add(number);

            permute(counts, nums, result, results);

            result.remove(result.size() - 1);
            counts.put(number, count);
        }
    }

    private Map<Integer, Integer> createCounts(int[] nums) {
        var table = new HashMap<Integer, Integer>();

        for (int num : nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }

        return table;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> counts = createCounts(nums);
        var results = new ArrayList<List<Integer>>();

        permute(counts, nums.length, new ArrayList<>(), results);

        return results;
    }
}
