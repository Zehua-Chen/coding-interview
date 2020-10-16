import utils.directed.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode next = head.next;

        if (next == null) {
            return head;
        }

        ListNode nextNext = next.next;

        next.next = head;
        head.next = swapPairs(nextNext);

        return next;
    }
}
