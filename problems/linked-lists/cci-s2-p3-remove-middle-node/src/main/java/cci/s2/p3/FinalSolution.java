package cci.s2.p3;

import utils.lists.Node;

public class FinalSolution implements Solution {
    @Override
    public void removeMiddle(Node<Integer> middle) {
        Node<Integer> next = middle.getNext();

        // end of list
        if (next == null) {
            return;
        }

        Node<Integer> next2 = next.getNext();

        middle.setValue(next.getValue());
        middle.setNext(next2);

        next.setNext(null);
    }
}
