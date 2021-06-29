package utils.cloning;

public class Arrays2D {
    /**
     * Clone a 2D int array
     *
     * @param input input 2D array
     * @return a clone of `input`
     */
    public static int[][] clone(int[][] input) {
        int[][] result = new int[input.length][];

        for (int y = 0; y < input.length; y++) {
            result[y] = new int[input[y].length];
            System.arraycopy(input[y], 0, result[y], 0, input[y].length);
        }

        return result;
    }
}
