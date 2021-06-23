package cci.s1.p3;

import static java.lang.System.out;

public class Program {
    static void copy(char[] target, String source) {
        assert target.length >= source.length();

        for (int i = 0; i < source.length(); i++) {
            target[i] = source.charAt(i);
        }
    }

    static void test(String input, String expected) {
        var solution = new Solution();
        char[] inputArray = new char[expected.length()];
        copy(inputArray, input);

        String actual = new String(solution.urlify(inputArray, input.length()));

        if (!actual.equals(expected)) {
            out.printf(
                    "input = %s, input len = %d, expected = %s, actual = %s\n",
                    input, input.length(), expected, actual);
        }
    }

    public static void main(String[] args) {
        test("a b", "a%20b");
        test("Mr John Smith", "Mr%20John%20Smith");
        test("a  b", "a%20%20b");
        test("abc", "abc");
    }
}
