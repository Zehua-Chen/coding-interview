package cci.s2.p1;

import utils.lists.Node;

public class NoBufferSolution implements Solution {
    @Override
    public void removeDuplicates(Node<Integer> head) {
        Node<Integer> compare = head;

        while (compare != null) {
            Node<Integer> runner = compare;

            while (runner.getNext() != null) {
                if (runner.getNext().getValue().equals(compare.getValue())) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }

            compare = compare.getNext();
        }
    }
}
