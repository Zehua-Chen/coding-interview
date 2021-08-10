package leetcode.p0054;

import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        var elements = new ArrayList<Integer>(width * height);

        int layers = (int) Math.ceil(Math.min(height, width) / 2.0);

        for (int layer = 0; layer < layers; layer++) {
            // minX == layer
            // minY == layer
            int maxX = width - 1 - layer;
            int maxY = height - 1 - layer;

            for (int x = layer; x <= maxX; x++) {
                elements.add(matrix[layer][x]);
            }

            for (int y = layer + 1; y <= maxY; y++) {
                elements.add(matrix[y][maxX]);
            }

            if (layer == maxX || layer == maxY) {
                continue;
            }

            for (int x = maxX - 1; x >= layer; x--) {
                elements.add(matrix[maxY][x]);
            }

            for (int y = maxY - 1; y >= layer + 1; y--) {
                elements.add(matrix[y][layer]);
            }
        }

        return elements;
    }
}
