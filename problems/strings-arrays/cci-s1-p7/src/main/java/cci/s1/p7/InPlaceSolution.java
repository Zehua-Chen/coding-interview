package cci.s1.p7;

public class InPlaceSolution implements Solution {
    @Override
    public void rotate(int[][] image) {
        int n = image.length;

        // Divide each layer into four segments and then swap the segments in the following manner
        // temp = top
        // top = right
        // right = bottom
        // bottom - left
        // left = temp

        for (int layer = 0; layer < n / 2; layer++) {
            int start = layer;
            int end = n - 1 - layer;

            for (int i = start; i < end; i++) {
                int offset = i - start;

                // top
                int temp = image[start][i];
                // top = right
                image[start][i] = image[i][end];
                // right = bottom
                image[i][end] = image[end][end - offset];
                // bottom = left
                image[end][end - offset] = image[end - offset][start];
                // left = top
                image[end - offset][start] = temp;
            }
        }
    }
}
