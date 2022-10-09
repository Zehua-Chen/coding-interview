public class Solution {
    private void subsets(int[] nums, int i, List<List<Integer>> results, List<Integer> element) {
        Integer previous = null;

        for (int ip = i + 1; ip < nums.length; ip++) {
            int num = nums[ip];

            if (previous != null && previous == num) {
                continue;
            }

            previous = num;

            element.add(num);
            results.add(new ArrayList<>(element));

            subsets(nums, ip, results, element);
            element.remove(element.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        var results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<>());
        Arrays.sort(nums);

        subsets(nums, -1, results, new ArrayList<>());

        return results;
    }
}
