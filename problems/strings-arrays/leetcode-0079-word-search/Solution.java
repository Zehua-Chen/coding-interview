public class Solution {
    private boolean exist(char[][] board, boolean[][] visited, int x, int y, String word, int i) {
        if (i == word.length() - 1) {
            return true;
        }

        int height = board.length;
        int width = board[0].length;

        boolean left = x - 1 >= 0;
        boolean right = x + 1 < width;

        char nextChar = word.charAt(i + 1);

        // top
        if (y - 1 >= 0 && board[y - 1][x] == nextChar && !visited[y - 1][x]) {
            visited[y - 1][x] = true;

            if (exist(board, visited, x, y - 1, word, i + 1)) {
                return true;
            }

            visited[y - 1][x] = false;
        }

        // bottom
        if (y + 1 < height && board[y + 1][x] == nextChar && !visited[y + 1][x]) {
            visited[y + 1][x] = true;

            if (exist(board, visited, x, y + 1, word, i + 1)) {
                return true;
            }

            visited[y + 1][x] = false;
        }

        // left
        if (x - 1 >= 0 && board[y][x - 1] == nextChar && !visited[y][x - 1]) {
            visited[y][x - 1] = true;

            if (exist(board, visited, x - 1, y, word, i + 1)) {
                return true;
            }

            visited[y][x - 1] = false;
        }

        // right
        if (x + 1 < width && board[y][x + 1] == nextChar && !visited[y][x + 1]) {
            visited[y][x + 1] = true;

            if (exist(board, visited, x + 1, y, word, i + 1)) {
                return true;
            }

            visited[y][x + 1] = false;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        var visited = new boolean[board.length][];

        for (int y = 0; y < board.length; y++) {
            visited[y] = new boolean[board[0].length];
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == word.charAt(0)) {
                    visited[y][x] = true;

                    if (exist(board, visited, x, y, word, 0)) {
                        return true;
                    }

                    visited[y][x] = false;
                }

            }
        }

        return false;
    }
}
