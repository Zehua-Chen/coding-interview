import utils.directed.ListNode;

public class Program {
  public static void test(int k, ListNode head, ListNode expected) {
    Solution solution = new Solution();
    ListNode actual = solution.reverseKGroup(head, k);

    if (actual == null || !expected.equals(actual)) {
      System.out.printf(
        "failed, k %d expects %s, actual %s\n", k, expected, actual);
    }
  }

  public static void main(String[] args) {
    test(1, ListNode.create(1, 2, 3, 4, 5), ListNode.create(1, 2, 3, 4, 5));
    test(2, ListNode.create(1, 2, 3, 4, 5), ListNode.create(2, 1, 4, 3 ,5));
    test(3, ListNode.create(1, 2, 3, 4, 5), ListNode.create(3, 2, 1, 4 ,5));
  }
}
