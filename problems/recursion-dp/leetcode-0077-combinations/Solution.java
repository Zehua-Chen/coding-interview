public class Solution {
    private void recurse(int ni, int n, int k, int count, boolean[] taken, List<List<Integer>> result) {
        if (count == k) {
            var combination = new ArrayList<Integer>();

            for (int takeni = 0; takeni < taken.length; takeni++) {
                if (taken[takeni]) {
                    combination.add(takeni);
                }
            }

            result.add(combination);
            return;
        }

        for (int takeni = ni; takeni < taken.length; takeni++) {
            if (taken[takeni]) {
                continue;
            }

            taken[takeni] = true;
            recurse(takeni, n, k, count + 1, taken, result);
            taken[takeni] = false;
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        // example:
        // 1, 2, 3, 4
        // 1, 2, 3,
        // 1, 2, 4
        // 1, 3, 4

        // 1, 2, 3, 4
        // 1, 2
        // 1, 3
        // 1, 4

        var result = new ArrayList<List<Integer>>();
        var taken = new boolean[n + 1];

        recurse(1, n, k, 0, taken, result);

        return result;
    }
}
