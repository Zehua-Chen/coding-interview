public class Application {
  public static void test(int[][] lists, int[] expected) {
    ListNode[] roots = new ListNode[lists.length];

    for (int i = 0; i < lists.length; i++) {
      roots[i] = ListNode.create(lists[i]);
    }

    Solution solution = new Solution();
    ListNode actual = solution.mergeKLists(roots);

    if (!actual.equals(expected)) {
      System.out.printf("expected: %s, found: %s", expected, actual);
    }
  }

  public static void main(String[] args) {
    test(
        new int[][] {
          new int[] {1, 3, 5},
          new int[] {1, 3, 5},
        },
        new int[] {1});
  }
}
