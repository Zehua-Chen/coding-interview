package leetcode.p0062;

public class RecursiveSolution {
    private int paths(int x, int y, int m, int n) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        } else if (x == n - 1) {
            return paths(x, y + 1, m, n);
        } else if (y == m - 1) {
            return paths(x + 1, y, m, n);
        }

        return paths(x + 1, y, m, n) + paths(x, y + 1, m, n);
    }

    /**
     * Count number of unique paths
     *
     * @param m height
     * @param n width
     * @return number of unique paths
     */
    public int uniquePaths(int m, int n) {
        return paths(0, 0, m, n);
    }
}
