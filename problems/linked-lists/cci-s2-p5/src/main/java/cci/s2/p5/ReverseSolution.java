package cci.s2.p5;

import utils.lists.Node;

public class ReverseSolution implements Solution {
    private Node<Integer> add(Node<Integer> a, Node<Integer> b, int over, Node<Integer> result) {
        if (a == null && b == null) {
            if (over != 0) {
                result.setNext(new Node<>(over));
            }

            return result;
        }

        if (a == null) {
            result.setNext(new Node<>(b));
            return result;
        }

        if (b == null) {
            result.setNext(new Node<>(a));

            return result;
        }

        int x = a.getValue() + b.getValue() + over;
        int current = x % 10;
        over = Math.floorDiv(x, 10);

        var node = new Node<>(current);
        add(a.getNext(), b.getNext(), over, node);
        result.setNext(node);

        return result;
    }

    @Override
    public Node<Integer> add(Node<Integer> a, Node<Integer> b) {
        // use a -1 node as the anchor so that we can start building the result
        Node<Integer> result = add(a, b, 0, new Node<>(-1));
        result = result.getNext();
        assert result != null;

        return result;
    }
}
