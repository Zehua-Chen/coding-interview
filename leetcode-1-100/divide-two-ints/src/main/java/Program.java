class Program {
  public static void test(int expected, int divident, int divisor) {
    Solution solution = new Solution();

    int actual = solution.divide(divident, divisor);

    if (expected != actual) {
      System.out.printf(
        "expected %d, found %d (%d / %d)\n",
        expected,
        actual,
        divident,
        divisor);
    }
  }

  public static void main(String[] args) {
    // positive / positive
    test(3, 10, 3);
    test(1, 10, 10);
    test(0, 0, 10);

    // positive / negative
    test(-2, 7, -3);
    test(-1, 7, -7);
    test(Integer.MAX_VALUE * -1, Integer.MAX_VALUE, -1);

    // negative / positive
    test(-2, -7, 3);
    test(-1, -7, 7);

    // negative / negative
    test(2, -7, -3);
    test(1, -7, -7);

    // overflow
    test(Integer.MAX_VALUE, Integer.MIN_VALUE, -1);
  }
}
