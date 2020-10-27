package p007;

public class Program {
    public static void test(String s, int expected) {
        var solution = new Solution();
        int actual = solution.eraseZeros(s);

        if (actual != expected) {
            System.out.printf("s = %s, expected = %d, actual = %d\n", s, expected, actual);
        }
    }

    public static void main(String[] args) {
        test("1111000", 0);
        test("0", 0);
        test("010011", 2);
    }
}
