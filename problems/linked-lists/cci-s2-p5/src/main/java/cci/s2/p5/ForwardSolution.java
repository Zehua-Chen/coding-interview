package cci.s2.p5;

import utils.lists.Node;

public class ForwardSolution implements Solution {
    private static class Result {
        int overflow;
        Node<Integer> result;

        public Result(int overflow, Node<Integer> result) {
            this.overflow = overflow;
            this.result = result;
        }
    }

    private Result _add(Node<Integer> a, Node<Integer> b) {
        if (a.getNext() == null && b.getNext() == null) {
            int x = a.getValue() + b.getValue();
            int overflow = Math.floorDiv(x, 10);
            int current = x % 10;

            return new Result(overflow, new Node<>(current));
        }

        assert a.getNext() != null;
        assert b.getNext() != null;

        Result prevResult = _add(a.getNext(), b.getNext());

        int x = a.getValue() + b.getValue() + prevResult.overflow;
        int overflow = Math.floorDiv(x, 10);
        int current = x % 10;

        var result = new Node<>(current);
        result.setNext(prevResult.result);

        return new Result(overflow, result);
    }

    int length(Node<Integer> head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.getNext();
        }

        return len;
    }

    Node<Integer> padPrefixZeros(Node<Integer> head, int count) {
        while (count > 0) {
            var node = new Node<>(0);
            node.setNext(head);
            head = node;
            count--;
        }

        return head;
    }

    @Override
    public Node<Integer> add(Node<Integer> a, Node<Integer> b) {
        int aLen = length(a);
        int bLen = length(b);

        if (aLen > bLen) {
            b = padPrefixZeros(b, aLen - bLen);
        } else if (aLen < bLen) {
            a = padPrefixZeros(a, bLen - aLen);
        }

        return _add(a, b).result;
    }
}
