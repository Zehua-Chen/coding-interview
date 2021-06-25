package cci.s1.p6;

import static java.lang.System.*;

public class Program {
    static void test(String input, String expected, Solution solution) {
        String actual = solution.compress(input);

        if (actual == null || !actual.equals(expected)) {
            out.printf(
                    "(%s) input = %s, actual = %s, expected = %s\n",
                    solution.getClass().getName(), input, actual, expected);
        }
    }

    static void test(String input, String expected) {
        var solutions = new Solution[] {new BaselineSolution()};

        for (Solution solution : solutions) {
            test(input, expected, solution);
        }
    }

    public static void main(String[] args) {
        test("aabcccccaaa", "a2b1c5a3");

        // not compressed
        test("abc", "abc");
        test("aab", "aab");
    }
}
