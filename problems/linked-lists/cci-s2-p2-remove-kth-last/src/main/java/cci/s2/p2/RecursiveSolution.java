package cci.s2.p2;

import utils.lists.Node;

public class RecursiveSolution implements Solution {
    private Tuple find(Node<Integer> head, int k) {
        if (head == null) {
            return new Tuple(null, 0);
        }

        Tuple output = find(head.getNext(), k);
        output.lastToEnd++;

        if (output.lastToEnd == k) {
            return new Tuple(head.getValue(), output.lastToEnd);
        }

        return new Tuple(output.value, output.lastToEnd);
    }

    @Override
    public Integer findLast(Node<Integer> head, int k) {
        Tuple output = find(head, k);
        assert output.value != null;

        return output.value;
    }
}
