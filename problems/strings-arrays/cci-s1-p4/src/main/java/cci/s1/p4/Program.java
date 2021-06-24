package cci.s1.p4;

import static java.lang.System.*;

public class Program {
    static <T extends Solution> void test(String string, boolean expected, Class<T> cls) {
        try {
            T solution = Solution.newInstance(cls);

            boolean actual = solution.isPalindromePermutation(string);

            if (actual != expected) {
                out.printf(
                        "(%s): string = %s, actual = %b, expected = %b\n",
                        cls.getName(), string, actual, expected);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    static void test(String string, boolean expected) {
        // baseline
        test(string, expected, BaselineSolution.class);
        test(string, expected, TableSolution.class);

        // best
        test(string, expected, BitVectorSolution.class);
    }

    public static void main(String[] args) {
        //        test("Tact Coa", true);
        //        test("abc", false);
        //        test("a acc", true);
        //        test("aaabbccc", false);
        var sln = new BitVectorSolution();

        out.println(sln.flip(3, 1));
        out.println(sln.flip(1, 1));
    }
}
