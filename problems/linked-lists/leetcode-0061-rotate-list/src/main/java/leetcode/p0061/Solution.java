package leetcode.p0061;

import utils.leetcode.ListNode;

public class Solution {
    /**
     * Obtain the length of a linked list
     *
     * @param head head of the linked list, cannot be null
     * @return size of the linked list
     */
    private int length(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    /**
     * Insert source into the end of target
     *
     * @param target target
     * @param source source
     */
    private void insert(ListNode target, ListNode source) {
        while (target.next != null) {
            target = target.next;
        }

        target.next = source;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = length(head);

        // index of node to move to front
        int fetch = length - (k % length);

        if (length == fetch) {
            return head;
        }

        ListNode preFetch = head;

        // find the node before fetch
        for (int i = 0; i < fetch - 1; i++) {
            preFetch = preFetch.next;
        }

        ListNode newHead = preFetch.next;
        preFetch.next = null;

        insert(newHead, head);

        return newHead;
    }
}
