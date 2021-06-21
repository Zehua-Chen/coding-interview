package p0036;

import java.util.*;

public class Solution {
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
}
