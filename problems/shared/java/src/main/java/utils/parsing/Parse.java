package utils.parsing;

public class Parse {
    /**
     * Parse a line-space separated matrix
     *
     * @param input input string
     * @return the parsed matrix
     */
    public static int[][] matrix(String input) {
        input = input.strip();

        String[] strRows = input.split("\n");
        int[][] rows = new int[strRows.length][];

        for (int y = 0; y < strRows.length; y++) {
            String[] segments = strRows[y].split(" ");
            int[] row = new int[segments.length];

            for (int x = 0; x < segments.length; x++) {
                row[x] = Integer.parseInt(segments[x]);
            }

            rows[y] = row;
        }

        return rows;
    }
}
