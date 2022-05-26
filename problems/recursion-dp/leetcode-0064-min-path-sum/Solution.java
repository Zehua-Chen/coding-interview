class Solution {
    private int[][] makeTable(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] table = new int[grid.length][];

        for (int y = 0; y < height; y++) {
            table[y] = new int[width];
        }

        return table;
    }

    private void printTable(int[][] table) {
        for (int[] row : table) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int minPathSum(int[][] grid) {
        int[][] table = makeTable(grid);
        int height = grid.length;
        int width = grid[0].length;

        table[height - 1][width - 1] = grid[height - 1][width - 1];

        for (int x = width - 2; x >= 0; x--) {
            int y = height - 1;

            table[y][x] = grid[y][x] + table[y][x + 1];
        }

        for (int y = height - 2; y >= 0; y--) {
            int x = width - 1;

            table[y][x] = grid[y][x] + table[y + 1][x];
        }

        for (int y = height - 2; y >= 0; y--) {
            for (int x = width - 2; x >= 0; x--) {
                table[y][x] = grid[y][x] + Math.min(table[y + 1][x], table[y][x + 1]);
            }
        }

        // printTable(grid);

        // System.out.println();
        // printTable(table);

        return table[0][0];
    }
}
