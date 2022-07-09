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
custom test cases
[]
[1]
[1,2]
[1,2,3]
[1,1,2]
[1,1,2,3,3]
[1,2,3,4,4,4,5]
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode read = head;
        ListNode write = head;

        while (read != null) {
            if (read.val != write.val) {
                write = write.next;
                write.val = read.val;
            }

            read = read.next;
        }

        write.next = null;

        return head;
    }
}
