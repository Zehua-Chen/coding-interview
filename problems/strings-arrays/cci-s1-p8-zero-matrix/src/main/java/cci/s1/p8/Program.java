package cci.s1.p8;

import java.io.*;
import java.util.*;

import utils.cloning.Arrays2D;
import utils.parsing.Parse;

import static java.lang.System.*;

public class Program {
    static void test(int[][] input, int[][] expected, Solution solution) {
        int[][] actual = Arrays2D.clone(input);

        solution.setZero(actual);

        if (!Arrays.deepEquals(actual, expected)) {
            out.printf(
                    "(%s) input = %s, actual = %s, expected = %s\n",
                    solution.getClass().getName(),
                    Arrays.deepToString(input),
                    Arrays.deepToString(actual),
                    Arrays.deepToString(expected));
        }
    }

    static void test(int[][] input, int[][] expected) {
        var solutions = new Solution[]{new BaselineSolution(), new InPlaceSolution()};

        for (Solution solution : solutions) {
            test(input, expected, solution);
        }
    }

    static void test(String file) {
        try (InputStream stream = Program.class.getResourceAsStream(file)) {
            if (stream == null) {
                out.printf("failed to obtain %s\n", file);
                System.exit(-1);
            }

            var content = new String(stream.readAllBytes());
            String[] segments = content.split("expected:");

            assert segments.length == 2;

            int[][] input = Parse.matrix(segments[0]);
            int[][] expected = Parse.matrix(segments[1]);

            test(input, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test("/test1.txt");
        test("/test2.txt");
        test("/test3.txt");
        test("/test4.txt");
    }
}
