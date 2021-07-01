package cci.s2.p4;

import utils.lists.Node;

public class SwapSolution implements Solution {
    private Node<Integer> findSmaller(Node<Integer> head, int partition) {
        boolean found = false;

        while (head != null) {
            if (head.getValue() < partition) {
                found = true;
                break;
            }

            head = head.getNext();
        }

        if (found) {
            return head;
        }

        return null;
    }

    @Override
    public Node<Integer> partition(Node<Integer> head, int partition) {
        Node<Integer> current = head;

        while (current != null) {
            if (current.getValue() >= partition) {
                Node<Integer> smaller = findSmaller(current, partition);

                if (smaller != null) {
                    Integer temp = smaller.getValue();
                    smaller.setValue(current.getValue());
                    current.setValue(temp);
                }
            }

            current = current.getNext();
        }

        return head;
    }
}
