public class Solution {
    public int climbStairs(int n) {
        var table = new int[n + 1];

        table[0] = 1;
        table[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }
}
