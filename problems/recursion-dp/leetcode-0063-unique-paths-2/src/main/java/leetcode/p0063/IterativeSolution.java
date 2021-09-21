package leetcode.p0063;

public class IterativeSolution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        var table = new int[height][];

        for (int y = 0; y < table.length; y++) {
            table[y] = new int[width];
        }

        if (obstacleGrid[height - 1][width - 1] == 0) {
            table[height - 1][width - 1] = 1;
        }

        // fill the last row
        for (int x = width - 2; x >= 0; x--) {
            table[height - 1][x] = obstacleGrid[height - 1][x] == 1 ? 0 : table[height - 1][x + 1];
        }

        // fill the last column
        for (int y = table.length - 2; y >= 0; y--) {
            table[y][width - 1] = obstacleGrid[y][width - 1] == 1 ? 0 : table[y + 1][width - 1];
        }

        for (int y = table.length - 2; y >= 0; y--) {
            for (int x = table[y].length - 2; x >= 0; x--) {
                table[y][x] = obstacleGrid[y][x] == 1 ? 0 : table[y + 1][x] + table[y][x + 1];
            }
        }

        return table[0][0];
    }
}
