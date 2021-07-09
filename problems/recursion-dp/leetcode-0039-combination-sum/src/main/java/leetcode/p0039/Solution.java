package leetcode.p0039;

import java.util.*;

public class Solution {
    List<List<Integer>> sum(int[] candidates, int target, int lastSelected, List<Integer> result) {
        if (target == 0) {
            return List.of(result);
        }

        if (target < 0) {
            return List.of();
        }

        var results = new ArrayList<List<Integer>>();

        for (int i = lastSelected; i < candidates.length; i++) {
            var newResult = new ArrayList<>(result);
            newResult.add(candidates[i]);
            results.addAll(sum(candidates, target - candidates[i], i, newResult));
        }

        return results;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var results = new ArrayList<List<Integer>>();

        for (int i = 0; i < candidates.length; i++) {
            var result = new ArrayList<Integer>();
            result.add(candidates[i]);

            results.addAll(sum(candidates, target - candidates[i], i, result));
        }

        return results;
    }
}
