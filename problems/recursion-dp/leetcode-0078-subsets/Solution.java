public class Solution {
    private void subsets(int[] nums, int i, List<List<Integer>> results, List<Integer> element) {
        // System.out.printf("i = %d\n", i);

        for (int ip = i + 1; ip < nums.length; ip++) {
            element.add(nums[ip]);
            results.add(new ArrayList<>(element));

            subsets(nums, ip, results, element);
            element.remove(element.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        var results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<>());

        subsets(nums, -1, results, new ArrayList<>());

        return results;
    }
}
