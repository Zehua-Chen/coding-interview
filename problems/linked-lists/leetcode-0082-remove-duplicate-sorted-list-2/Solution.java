/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
Custom test cases

[1,2,3]
[1]
[]
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            ListNode next = head.next;

            while (next != null && next.val == head.val) {
                next = next.next;
            }

            return deleteDuplicates(next);
        }

        head.next = deleteDuplicates(head.next);

        return head;
    }
}
