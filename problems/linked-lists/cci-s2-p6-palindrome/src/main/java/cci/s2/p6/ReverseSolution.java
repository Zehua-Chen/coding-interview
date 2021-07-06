package cci.s2.p6;

import utils.lists.Node;

public class ReverseSolution implements Solution {
    private static class Reverse {
        Node<Character> head;
        Node<Character> insert;

        public Reverse(Node<Character> head, Node<Character> insert) {
            this.head = head;
            this.insert = insert;
        }
    }

    private Reverse reverse(Node<Character> head) {
        if (head.getNext() == null) {
            var newHead = new Node<>(head.getValue());
            return new Reverse(newHead, newHead);
        }

        Reverse r = reverse(head.getNext());
        var newNode = new Node<>(head.getValue());
        r.insert.setNext(newNode);

        return new Reverse(r.head, newNode);
    }

    private boolean equals(Node<Character> a, Node<Character> b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (!a.getValue().equals(b.getValue())) {
            return false;
        }

        return equals(a.getNext(), b.getNext());
    }

    @Override
    public boolean isPalindrome(Node<Character> head) {
        Node<Character> reversed = reverse(head).head;
        return equals(reversed, head);
    }
}
