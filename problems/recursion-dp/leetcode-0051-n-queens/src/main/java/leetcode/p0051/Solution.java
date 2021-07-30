package leetcode.p0051;

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

    private String createRow(int x, int n) {
        var builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i == x) {
                builder.append('Q');
            } else {
                builder.append('.');
            }
        }

        return builder.toString();
    }

    private void solve(
            int yStart,
            int count,
            boolean[] columns,
            List<Position> queens,
            List<List<String>> results,
            List<String> result,
            int n) {
        if (yStart == n) {
            if (count == n) {
                results.add(new ArrayList<>(result));
                return;
            }

            return;
        }

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
            String row = createRow(x, n);

            result.add(row);
            columns[x] = true;
            queens.add(new Position(yStart, x));

            solve(yStart + 1, count + 1, columns, queens, results, result, n);

            queens.remove(queens.size() - 1);
            result.remove(result.size() - 1);
            columns[x] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        var results = new ArrayList<List<String>>();

        solve(0, 0, new boolean[n], new ArrayList<>(), results, new ArrayList<>(), n);

        return results;
    }
}
