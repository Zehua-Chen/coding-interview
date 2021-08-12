package leetcode.p0059;

public class Solution {
    public int[][] generateMatrix(int n) {
        var layers = (int) Math.ceil(n / 2.0);
        var matrix = new int[n][];

        for (int y = 0; y < n; y++) {
            matrix[y] = new int[n];
        }

        int i = 1;

        for (int layer = 0; layer < layers; layer++) {
            // layer = min
            int max = n - layer - 1;

            for (int x = layer; x <= max; x++) {
                matrix[layer][x] = i++;
            }

            for (int y = layer + 1; y <= max; y++) {
                matrix[y][max] = i++;
            }

            if (layer == max) {
                continue;
            }

            for (int x = max - 1; x >= layer; x--) {
                matrix[max][x] = i++;
            }

            for (int y = max - 1; y >= layer + 1; y--) {
                matrix[y][layer] = i++;
            }
        }

        return matrix;
    }
}
