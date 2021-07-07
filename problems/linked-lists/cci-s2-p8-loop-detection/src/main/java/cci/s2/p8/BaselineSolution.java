package cci.s2.p8;

import java.util.*;

import utils.Reference;
import utils.lists.Node;

public class BaselineSolution implements Solution {
    @Override
    public Node<Integer> findLoopHead(Node<Integer> list) {
        var set = new HashSet<Reference<Node<Integer>>>();

        while (list != null) {
            if (set.contains(new Reference<>(list))) {
                return list;
            }

            set.add(new Reference<>(list));
            list = list.getNext();
        }

        return null;
    }
}
