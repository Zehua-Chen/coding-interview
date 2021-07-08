package cci.s3.p3;

import java.util.*;

public class RemoveAtIndexSetOfStacks<E> extends BaselineSetOfStacks<E> {
    public RemoveAtIndexSetOfStacks(int threshold) {
        super(threshold);
    }

    public E popAt(int index) {
        return stacks.get(index).pop();
    }

    @Override
    public E pop() {
        while (!stacks.isEmpty()) {
            Stack<E> stack = stacks.peek();

            if (stack.isEmpty()) {
                stacks.pop();
                continue;
            }

            return stack.pop();
        }

        return null;
    }
}
