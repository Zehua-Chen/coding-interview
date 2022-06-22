public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // treat the matrix as an array
        // perform binary search

        int height = matrix.length;
        int width = matrix[0].length;
        int length = width * height;

        IntFunction<Integer> get = (int index) -> {
            int x = index % width;
            int y = index / width;

            return matrix[y][x];
        };

        int start = 0;
        int end = length - 1;

        while (end - start > 1) {
            int range = end - start + 1;
            int mid = start + range / 2;

            int midValue = get.apply(mid);

            if (target < midValue) {
                end = mid;
            } else if (target > midValue) {
                start = mid;
            } else {
                return true;
            }
        }

        return get.apply(end) == target || get.apply(start) == target;
    }
}
