package cci.s2.p8;

import utils.lists.Node;

public class TwoPointerSolution implements Solution {
    @Override
    public Node<Integer> findLoopHead(Node<Integer> list) {
        Node<Integer> slow = list;
        Node<Integer> fast = list;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                break;
            }
        }

        if (fast != slow) {
            return null;
        }

        slow = list;

        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return fast;
    }
}
