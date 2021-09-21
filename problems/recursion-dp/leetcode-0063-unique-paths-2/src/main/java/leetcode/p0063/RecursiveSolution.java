package leetcode.p0063;

public class RecursiveSolution {
    private int paths(int x, int y, int[][] grid) {
        if (y == grid.length - 1 && x == grid[0].length - 1) {
            return grid[y][x] == 1 ? 0 : 1;
        } else if (x == grid.length - 1) {
            return grid[y][x] == 1 ? 0 : paths(x, y + 1, grid);
        } else if (y == grid.length - 1) {
            return grid[y][x] == 1 ? 0 : paths(x + 1, y, grid);
        }

        if (grid[y][x] == 1) {
            return 0;
        }

        return paths(x + 1, y, grid) + paths(x, y + 1, grid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return paths(0, 0, obstacleGrid);
    }
}
