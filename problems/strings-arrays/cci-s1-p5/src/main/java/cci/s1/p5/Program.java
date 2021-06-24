package cci.s1.p5;

import static java.lang.System.*;

public class Program {
    static void test(String a, String b, boolean expected, Solution solution) {
        boolean actual = solution.areOneEditAway(a, b);

        if (actual != expected) {
            out.printf(
                    "(%s): a = %s, b = %s, actual = %b, expected = %b\n",
                    solution.getClass().getName(), a, b, actual, expected);
        }
    }

    static void test(String a, String b, boolean expected) {
        var solutions = new Solution[] {new BaselineSolution()};

        for (Solution solution : solutions) {
            test(a, b, expected, solution);
        }
    }

    public static void main(String[] args) {
        test("pale", "ple", true);
        test("pales", "pale", true);
        test("pales", "bale", true);
        test("pale", "bake", false);
    }
}
