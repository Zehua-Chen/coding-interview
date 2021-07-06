package cci.s2.p6;

import java.util.*;

import utils.lists.Node;

public class TwoPointerSolution implements Solution {
    @Override
    public boolean isPalindrome(Node<Character> head) {
        Node<Character> fast = head;
        Node<Character> slow = head;

        var stack = new Stack<Character>();

        while (fast != null && fast.getNext() != null) {
            stack.add(slow.getValue());

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // odd length
        if (fast != null) {
            stack.add(slow.getValue());
        }

        while (slow != null) {
            if (!stack.pop().equals(slow.getValue())) {
                return false;
            }

            slow = slow.getNext();
        }

        return true;
    }
}
