package cci.s2.p1;

import java.util.*;

import utils.lists.Node;

public class BaselineSolution implements Solution {
    @Override
    public void removeDuplicates(Node<Integer> head) {
        var set = new HashSet<Integer>();
        set.add(head.getValue());

        Node<Integer> current = head;

        while (current != null) {
            Node<Integer> candidate = current.getNext();

            while (candidate != null && set.contains(candidate.getValue())) {
                candidate = candidate.getNext();
            }

            if (candidate != null) {
                set.add(candidate.getValue());
            }

            current.setNext(candidate);
            current = candidate;
        }
    }
}
