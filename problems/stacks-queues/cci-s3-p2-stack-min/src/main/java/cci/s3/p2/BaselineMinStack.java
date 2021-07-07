package cci.s3.p2;

import java.util.*;

public class BaselineMinStack implements MinStack {
    private static class Node {
        int element;
        /**
         * Minimum value of the sub-stack, which includes all element before this node and this node
         * itself.
         */
        int minOfSubStack;

        public Node(int element, int minOfSubStack) {
            this.element = element;
            this.minOfSubStack = minOfSubStack;
        }
    }

    private final ArrayList<Node> buffer = new ArrayList<>();

    public void push(int element) {
        if (buffer.isEmpty()) {
            buffer.add(new Node(element, element));
            return;
        }

        Node previous = buffer.get(buffer.size() - 1);

        if (previous.minOfSubStack < element) {
            buffer.add(new Node(element, previous.minOfSubStack));
        } else {
            buffer.add(new Node(element, element));
        }
    }

    public int pop() {
        Node last = buffer.get(buffer.size() - 1);
        buffer.remove(buffer.size() - 1);

        return last.element;
    }

    public int min() {
        return buffer.get(buffer.size() - 1).minOfSubStack;
    }
}
