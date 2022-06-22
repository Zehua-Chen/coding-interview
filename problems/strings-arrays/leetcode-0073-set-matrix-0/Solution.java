class Solution {
    private void print(int[][] matrix) {
        for (int m = 0; m < matrix.length; m++) {
            System.out.println(Arrays.toString(matrix[m]));
        }
    }

    public void setZeroes(int[][] matrix) {
        // if first rows or cols is not scanned separately, then a zero in
        // first row or first col will cause matrix[0][0] to be set to 0,
        // and consequentially the entire first row and first col to be set to
        // 0
        boolean clearM0 = false;
        boolean clearN0 = false;

        for (int m = 0; m < matrix.length; m++) {
            if (matrix[m][0] == 0) {
                clearN0 = true;
                break;
            }
        }

        for (int n = 0; n < matrix[0].length; n++) {
            if (matrix[0][n] == 0) {
                clearM0 = true;
                break;
            }
        }

        for (int m = 1; m < matrix.length; m++) {
            for (int n = 1; n < matrix[m].length; n++) {
                if (matrix[m][n] == 0) {
                    matrix[m][0] = 0;
                    matrix[0][n] = 0;
                }
            }
        }

        // print(matrix);

        // have to start with m = 1, so that we don't temper with our markers

        for (int m = 1; m < matrix.length; m++) {
            if (matrix[m][0] != 0) {
                continue;
            }

            for (int n = 0; n < matrix[m].length; n++) {
                matrix[m][n] = 0;
            }
        }

        for (int n = 1; n < matrix[0].length; n++) {
            if (matrix[0][n] != 0) {
                continue;
            }

            for (int m = 0; m < matrix.length; m++) {
                matrix[m][n] = 0;
            }
        }

        if (clearM0) {
            for (int n = 0; n < matrix[0].length; n++) {
                matrix[0][n] = 0;
            }
        }

        if (clearN0) {
            for (int m = 0; m < matrix.length; m++) {
                matrix[m][0] = 0;
            }
        }
    }
}
