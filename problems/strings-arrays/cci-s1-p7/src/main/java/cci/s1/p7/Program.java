package cci.s1.p7;

import java.io.*;
import java.util.*;

import utils.parsing.Parse;

import static java.lang.System.*;

public class Program {
    static void test(int[][] input, int[][] expected, Solution solution) {
        int[][] image = new int[input.length][];

        for (int y = 0; y < input.length; y++) {
            int[] row = input[y];
            int[] newRow = new int[row.length];

            System.arraycopy(row, 0, newRow, 0, row.length);

            image[y] = newRow;
        }
        solution.rotate(image);

        if (!Arrays.deepEquals(expected, image)) {
            out.printf(
                    "(%s) input = %s, actual = %s, expected = %s\n",
                    solution.getClass().getName(),
                    Arrays.deepToString(input),
                    Arrays.deepToString(image),
                    Arrays.deepToString(expected));
        }
    }

    static void test(int[][] input, int[][] expected) {
        var solutions = new Solution[] {new BaselineSolution()};

        for (Solution solution : solutions) {
            test(input, expected, solution);
        }
    }

    static void test(String resource) {
        try (InputStream stream = Program.class.getResourceAsStream(resource)) {
            if (stream == null) {
                return;
            }

            String content = new String(stream.readAllBytes());
            String[] portions = content.split("rotated:");

            assert portions.length == 2;

            int[][] input = Parse.matrix(portions[0]);
            int[][] expected = Parse.matrix(portions[1]);

            test(input, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test("/test1.txt");
    }
}
