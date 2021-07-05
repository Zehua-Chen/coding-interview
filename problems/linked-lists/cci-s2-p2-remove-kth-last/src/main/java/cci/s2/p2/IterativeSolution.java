package cci.s2.p2;

import utils.lists.Node;

public class IterativeSolution implements Solution {
    @Override
    public Integer findLast(Node<Integer> head, int k) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.getNext();
        }

        if (fast == null) {
            return null;
        }

        while (fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        assert slow != null;

        return slow.getValue();
    }
}
