package leetcode.p0052;

import java.util.*;

public class Solution {
    private static class Position {
        public int y;
        public int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private int solve(int yStart, int count, boolean[] columns, List<Position> queens, int n) {
        if (yStart == n) {
            if (count == n) {
                return 1;
            }

            return 0;
        }

        int solutions = 0;

        xLoop:
        for (int x = 0; x < n; x++) {
            if (columns[x]) {
                continue;
            }

            for (Position queen : queens) {
                int xDiff = Math.abs(queen.x - x);
                int yDiff = Math.abs(queen.y - yStart);

                if (xDiff == yDiff) {
                    continue xLoop;
                }
            }

            // place
            columns[x] = true;
            queens.add(new Position(yStart, x));

            solutions += solve(yStart + 1, count + 1, columns, queens, n);

            queens.remove(queens.size() - 1);
            columns[x] = false;
        }

        return solutions;
    }

    public int totalNQueens(int n) {
        return solve(0, 0, new boolean[n], new ArrayList<>(), n);
    }
}
