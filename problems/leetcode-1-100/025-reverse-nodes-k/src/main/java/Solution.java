import utils.leetcode.ListNode;

public class Solution {
    private boolean hasLength(ListNode head, int k) {
        assert k > 0;

        if (head == null) {
            return false;
        }

        ListNode current = head;

        for (int i = 1; i < k; i++) {
            current = current.next;

            if (current == null) {
                return false;
            }
        }

        return true;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        if (head == null) {
            return null;
        }

        if (!hasLength(head, k)) {
            return head;
        }

        ListNode first = head;
        ListNode tail = head;
        ListNode current = head.next;

        for (int i = 1; i < k; i++) {
            ListNode next = current.next;
            current.next = first;
            first = current;

            current = next;
        }

        // based on how we change current, by this point, current would be
        // the next of kth node
        tail.next = reverseKGroup(current, k);

        return first;
    }
}
