public class Program {
    public static void test(String s, int expected) {
        var solution = new Solution();
        int actual = solution.longestValidParentheses(s);

        if (actual != expected) {
            System.out.printf("for string = %s, expected = %d, actual = %d", s, expected, actual);
        }
    }

    public static void main(String[] args) {
        test("(()", 2);
        test(")()())", 4);
        test("", 0);
        test(")(", 0);
    }
}
