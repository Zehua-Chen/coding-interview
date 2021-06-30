import utils.leetcode.ListNode;

class Program {
    public static void test(ListNode list, ListNode expected) {
        Solution solution = new Solution();
        ListNode output = solution.swapPairs(list);

        if (output == null) {
            return;
        }

        if (!output.equals(expected)) {
            System.out.println("failed");
            System.out.printf("found %s, ", output);
            System.out.printf("expected %s", expected);
        }
    }

    public static void main(String[] args) {
        test(null, null);
        test(ListNode.create(1), ListNode.create(1));
        test(ListNode.create(1, 2, 3, 4), ListNode.create(2, 1, 4, 3));
        test(ListNode.create(1, 2, 3, 4, 5), ListNode.create(2, 1, 4, 3, 5));
    }
}
