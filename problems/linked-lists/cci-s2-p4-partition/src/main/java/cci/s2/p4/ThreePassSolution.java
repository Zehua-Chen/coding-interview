package cci.s2.p4;

import java.util.function.*;

import utils.lists.Node;

public class ThreePassSolution implements Solution {
    @Override
    public Node<Integer> partition(Node<Integer> head, int partition) {
        var output =
                new Object() {
                    Node<Integer> head = null;
                    Node<Integer> insert = null;
                };

        Node<Integer> current = head;

        Consumer<Integer> add =
                (value) -> {
                    if (output.head == null) {
                        output.head = new Node<>(value);
                        output.insert = output.head;
                        return;
                    }

                    var node = new Node<>(value);
                    output.insert.setNext(node);
                    output.insert = node;
                };

        while (current != null) {
            if (current.getValue() < partition) {
                add.accept(current.getValue());
            }

            current = current.getNext();
        }

        current = head;

        while (current != null) {
            if (current.getValue() >= partition) {
                add.accept(current.getValue());
            }

            current = current.getNext();
        }

        return output.head;
    }
}
