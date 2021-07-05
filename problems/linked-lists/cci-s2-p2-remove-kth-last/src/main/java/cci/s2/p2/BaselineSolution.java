package cci.s2.p2;

import utils.lists.Node;

public class BaselineSolution implements Solution {
    int length(Node<Integer> head) {
        int count = 0;

        while (head != null) {
            head = head.getNext();
            count++;
        }

        return count;
    }

    @Override
    public Integer findLast(Node<Integer> head, int k) {
        int length = length(head);
        int index = 0;

        while (index < (length - k)) {
            head = head.getNext();
            index++;
        }

        return head.getValue();
    }
}
