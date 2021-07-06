package cci.s2.p7;

import utils.lists.Node;

public class ConstantSpaceSolution implements Solution {
    private int length(Node<Integer> head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.getNext();
        }

        return length;
    }

    Node<Integer> skips(Node<Integer> head, int size) {
        while (size > 0) {
            head = head.getNext();
            size--;
        }

        return head;
    }

    @Override
    public Node<Integer> intersects(Node<Integer> a, Node<Integer> b) {
        int lenA = length(a);
        int lenB = length(b);

        if (lenA > lenB) {
            a = skips(a, lenA - lenB);
        } else {
            b = skips(b, lenB - lenA);
        }

        while (a != null && b != null && a != b) {
            a = a.getNext();
            b = b.getNext();
        }

        return a;
    }
}
