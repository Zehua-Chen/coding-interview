package cci.s3.p2;

import java.util.*;

public class LessSpaceMinStack implements MinStack {
    private final Stack<Integer> mins = new Stack<>();
    private final Stack<Integer> stack = new Stack<>();

    @Override
    public void push(int element) {
        if (stack.size() == 0) {
            mins.add(element);
            stack.add(element);

            return;
        }

        int min = mins.peek();

        if (min > element) {
            mins.push(element);
        }

        stack.push(element);
    }

    @Override
    public int pop() {
        int element = stack.pop();

        if (element == mins.peek()) {
            mins.pop();
        }

        return element;
    }

    @Override
    public int min() {
        return mins.peek();
    }
}
