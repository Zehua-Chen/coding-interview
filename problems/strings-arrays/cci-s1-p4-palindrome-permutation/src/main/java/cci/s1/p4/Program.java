package cci.s1.p4;

import static java.lang.System.*;

public class Program {
    static void test(String string, boolean expected, Solution solution) {
        boolean actual = solution.isPalindromePermutation(string);

        if (actual != expected) {
            out.printf(
                    "(%s): string = %s, actual = %b, expected = %b\n",
                    solution.getClass().getName(), string, actual, expected);
        }
    }

    static void test(String string, boolean expected) {
        var solutions =
                new Solution[]{
                        new BaselineSolution(),
                        new TableSolution(),
                        // best
                        new BitVectorSolution()
                };

        for (Solution solution : solutions) {
            test(string, expected, solution);
        }
    }

    public static void main(String[] args) {
        test("Tact Coa", true);
        test("abc", false);
        test("a acc", true);
        test("aaabbccc", false);
    }
}
