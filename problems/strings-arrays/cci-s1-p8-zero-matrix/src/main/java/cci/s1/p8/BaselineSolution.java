package cci.s1.p8;

import java.util.*;

public class BaselineSolution implements Solution {
    @Override
    public void setZero(int[][] input) {
        var rows = new HashSet<Integer>();
        var cols = new HashSet<Integer>();

        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length; x++) {
                if (input[y][x] == 0) {
                    rows.add(y);
                    cols.add(x);
                }
            }
        }

        for (Integer row : rows) {
            for (int x = 0; x < input[0].length; x++) {
                input[row][x] = 0;
            }
        }

        for (Integer col : cols) {
            for (int y = 0; y < input.length; y++) {
                input[y][col] = 0;
            }
        }
    }
}
