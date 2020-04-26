public class Program {
  public static void test(String haystack, String needle, int expected) {
    Solution solution = new Solution();
    int actual = solution.strStr(haystack, needle);

    if (actual != expected) {
      System.out.printf("expected %d, actual: %d\n", expected, actual);
    }
  }

  public static void main(String[] args) {
    test("hello", "", 0);
    test("a", "a", 0);
    test("hello", "ll", 2);
    test("hello", "hello world!", -1);
    test("aaaaa", "bba", -1);
    test("aa", "a", 0);
    test("mississippi", "issip", 4);
    test("mississippi", "pi", 9);

    test("aa", "ba", -1);
  }
}
