package cci.s3.p3;

import java.util.*;

public class BaselineSetOfStacks<E> implements SetOfStacks<E> {
    protected final Stack<Stack<E>> stacks = new Stack<>();
    protected final int threshold;

    public BaselineSetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void push(E element) {
        if (stacks.isEmpty()) {
            stacks.push(new Stack<>());
        }

        Stack<E> stack = stacks.peek();

        if (stack.size() == threshold) {
            stack = new Stack<>();
            stacks.push(stack);
        }

        stack.push(element);
    }

    @Override
    public E pop() {
        Stack<E> stack = stacks.peek();

        if (stack.isEmpty()) {
            stacks.pop();
            stack = stacks.peek();
        }

        return stack.pop();
    }
}
