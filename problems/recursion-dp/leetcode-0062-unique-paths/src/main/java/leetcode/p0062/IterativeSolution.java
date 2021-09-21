package leetcode.p0062;

public class IterativeSolution {
    public int uniquePaths(int m, int n) {
        var table = new int[m][];

        for (int y = 0; y < table.length; y++) {
            table[y] = new int[n];
        }

        // fill the last row
        for (int x = table[m - 1].length - 1; x >= 0; x--) {
            table[m - 1][x] = 1;
        }

        for (int y = table.length - 1; y >= 0; y--) {
            table[y][n - 1] = 1;
        }

        for (int y = table.length - 2; y >= 0; y--) {
            for (int x = table[y].length - 2; x >= 0; x--) {
                table[y][x] = table[y + 1][x] + table[y][x + 1];
            }
        }

        return table[0][0];
    }
}
