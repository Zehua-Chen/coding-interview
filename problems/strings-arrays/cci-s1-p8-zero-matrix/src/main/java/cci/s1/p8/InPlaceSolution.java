package cci.s1.p8;

import java.util.*;

public class InPlaceSolution implements Solution {
    @Override
    public void setZero(int[][] input) {
        boolean clearRow0 = false;
        boolean clearCol0 = false;

        for (int[] row : input) {
            if (row[0] == 0) {
                clearCol0 = true;
                break;
            }
        }

        for (int x = 0; x < input[0].length; x++) {
            if (input[0][x] == 0) {
                clearRow0 = true;
                break;
            }
        }

        for (int y = 1; y < input.length; y++) {
            for (int x = 1; x < input[y].length; x++) {
                if (input[y][x] == 0) {
                    input[y][0] = 0;
                    input[0][x] = 0;
                }
            }
        }

        for (int y = 1; y < input.length; y++) {
            for (int x = 1; x < input[y].length; x++) {
                if (input[y][0] == 0 || input[0][x] == 0) {
                    input[y][x] = 0;
                }
            }
        }

        if (clearRow0) {
            Arrays.fill(input[0], 0);
        }

        if (clearCol0) {
            for (int y = 0; y < input.length; y++) {
                input[y][0] = 0;
            }
        }
    }
}
