package cci.s1.p1;

import static java.lang.System.out;

public class Program {
    static void test(String s, boolean expected) {
        var solution = new Solution();
        boolean actual = solution.areAllCharsUnique(s);

        if (actual != expected) {
            out.printf("s = %s, expected = %b, actual = %b\n", s, expected, actual);
        }
    }

    public static void main(String[] args) {
        test("abc", true);
        test("abb", false);
        test("aBA", true);
    }
}
