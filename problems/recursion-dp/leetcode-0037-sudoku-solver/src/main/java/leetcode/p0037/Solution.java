package leetcode.p0037;

import java.util.*;

public class Solution {
    private static class Cell {
        int y;
        int x;

        public Cell(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static final int BOX_SIZE = 9;
    static final int SUBBOX_SIZE = 3;

    public boolean isValidSudoku(char[][] board) {
        // go through rows
        for (int y = 0; y < BOX_SIZE; y++) {
            char[] row = board[y];
            var set = new HashSet<Character>();

            for (int x = 0; x < BOX_SIZE; x++) {
                char cell = row[x];

                if (cell == '.') {
                    continue;
                }

                if (set.contains(cell)) {
                    return false;
                }

                set.add(cell);
            }
        }

        // go through columns
        for (int x = 0; x < BOX_SIZE; x++) {
            var set = new HashSet<Character>();

            for (int y = 0; y < BOX_SIZE; y++) {
                char cell = board[y][x];

                if (cell == '.') {
                    continue;
                }

                if (set.contains(cell)) {
                    return false;
                }

                set.add(cell);
            }
        }

        // go through 3x3 blocks
        for (int boxY = 0; boxY < (BOX_SIZE / SUBBOX_SIZE); boxY++) {
            for (int boxX = 0; boxX < (BOX_SIZE / SUBBOX_SIZE); boxX++) {
                var set = new HashSet<Character>();

                for (int y = boxY * 3; y < boxY * 3 + SUBBOX_SIZE; y++) {
                    for (int x = boxX * 3; x < boxX * 3 + SUBBOX_SIZE; x++) {
                        char cell = board[y][x];

                        if (cell == '.') {
                            continue;
                        }

                        if (set.contains(cell)) {
                            return false;
                        }

                        set.add(cell);
                    }
                }
            }
        }

        return true;
    }

    private List<Cell> findEmptyCells(char[][] board) {
        var cells = new ArrayList<Cell>();

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == '.') {
                    cells.add(new Cell(y, x));
                }
            }
        }

        return cells;
    }

    private boolean solveSudoku(
            char[][] board,
            List<Cell> emptyCells,
            int i,
            boolean[][] rows,
            boolean[][] cols,
            boolean[][][] boxes) {
        if (i == emptyCells.size()) {
            return isValidSudoku(board);
        }

        for (int number = 1; number < 10; number++) {
            Cell cell = emptyCells.get(i);

            int boxY = cell.y / 3;
            int boxX = cell.x / 3;

            if (rows[cell.y][number] || cols[cell.x][number] || boxes[boxY][boxX][number]) {
                continue;
            }

            rows[cell.y][number] = true;
            cols[cell.x][number] = true;
            boxes[boxY][boxX][number] = true;

            board[cell.y][cell.x] = Character.forDigit(number, 10);

            if (solveSudoku(board, emptyCells, i + 1, rows, cols, boxes)) {
                return true;
            }

            board[cell.y][cell.x] = '.';
            rows[cell.y][number] = false;
            cols[cell.x][number] = false;
            boxes[boxY][boxX][number] = false;
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        List<Cell> emptyCells = findEmptyCells(board);
        boolean[][] rows = new boolean[9][];
        boolean[][] cols = new boolean[9][];
        boolean[][][] boxes = new boolean[3][][];

        for (int y = 0; y < 9; y++) {
            rows[y] = new boolean[10];

            for (int x = 0; x < 9; x++) {
                char cell = board[y][x];

                if (cell == '.') {
                    continue;
                }

                rows[y][Character.digit(cell, 10)] = true;
            }
        }

        for (int x = 0; x < 9; x++) {
            cols[x] = new boolean[10];

            for (int y = 0; y < 9; y++) {
                char cell = board[y][x];

                if (cell == '.') {
                    continue;
                }

                cols[x][Character.digit(cell, 10)] = true;
            }
        }

        for (int boxY = 0; boxY < (BOX_SIZE / SUBBOX_SIZE); boxY++) {
            boxes[boxY] = new boolean[3][];

            for (int boxX = 0; boxX < (BOX_SIZE / SUBBOX_SIZE); boxX++) {
                boxes[boxY][boxX] = new boolean[10];

                for (int y = boxY * 3; y < boxY * 3 + SUBBOX_SIZE; y++) {
                    for (int x = boxX * 3; x < boxX * 3 + SUBBOX_SIZE; x++) {
                        char cell = board[y][x];

                        if (cell == '.') {
                            continue;
                        }

                        boxes[boxY][boxX][Character.digit(cell, 10)] = true;
                    }
                }
            }
        }

        solveSudoku(board, emptyCells, 0, rows, cols, boxes);
    }
}
