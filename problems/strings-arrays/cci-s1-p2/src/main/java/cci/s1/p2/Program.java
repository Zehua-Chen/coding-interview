package cci.s1.p2;

import static java.lang.System.out;

public class Program {
    static void test(String original, String candidate, boolean expected) {
        var solution = new Solution();
        boolean actual = solution.isPermutation(original, candidate);

        if (actual != expected) {
            out.printf(
                    "original = %s, candidate = %s, actual = %b, expected = %b\n",
                    original, candidate, actual, expected);
        }
    }

    public static void main(String[] args) {
        test("abcde", "abdce", true);
        test("abcde", "abbbb", false);
    }
}
