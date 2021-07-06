package cci.s2.p6;

import java.util.*;

import utils.lists.Node;

public class StackSolution implements Solution {
    private static class Result {
        Stack<Character> stack;
        boolean isPalindrome;

        public Result(Stack<Character> stack, boolean isPalindrome) {
            this.stack = stack;
            this.isPalindrome = isPalindrome;
        }
    }

    private Stack<Character> makeStack(Node<Character> head) {
        if (head == null) {
            return new Stack<>();
        }

        Stack<Character> stack = makeStack(head.getNext());
        stack.add(head.getValue());

        return stack;
    }

    private int length(Node<Character> head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.getNext();
        }

        return length;
    }

    private Result isPalindrome(Node<Character> head, int depth, int length) {
        int halfDepth = length % 2 == 0 ? length / 2 - 1 : length / 2;

        if (depth == halfDepth) {
            Stack<Character> stack = length % 2 == 0 ? makeStack(head.getNext()) : makeStack(head);
            boolean isPalindrome = stack.pop().equals(head.getValue());

            return new Result(stack, isPalindrome);
        }

        Result prev = isPalindrome(head.getNext(), depth + 1, length);

        if (!prev.isPalindrome) {
            return prev;
        }

        prev.isPalindrome = prev.stack.pop().equals(head.getValue());

        return prev;
    }

    @Override
    public boolean isPalindrome(Node<Character> head) {
        return isPalindrome(head, 0, length(head)).isPalindrome;
    }
}
