package leetcode.p0046;

import java.util.*;

public class BaselineSolution {
    private void permute(Set<Integer> nums, List<Integer> result, List<List<Integer>> results) {
        if (nums.size() == 0) {
            results.add(new ArrayList<>(result));
        }

        var subNums = new HashSet<>(nums);

        for (int num : nums) {
            subNums.remove(num);
            result.add(num);

            permute(subNums, result, results);

            result.remove(result.size() - 1);
            subNums.add(num);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        var numsSet = new HashSet<Integer>();
        var results = new ArrayList<List<Integer>>();

        for (int num : nums) {
            numsSet.add(num);
        }

        permute(numsSet, new ArrayList<>(), results);

        return results;
    }
}
