package cci.s3.p1;

import java.util.*;

public class MultiStack<E> {
    private static class StackInfo {
        int start;
        int size;
        int capacity;

        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }
    }

    private final StackInfo[] stacks;
    private final ArrayList<E> buffer;

    MultiStack(int numStacks, int capacityPerStack) {
        stacks = new StackInfo[numStacks];

        for (int stack = 0; stack < stacks.length; stack++) {
            stacks[stack] = new StackInfo(stack * capacityPerStack, capacityPerStack);
        }

        buffer = new ArrayList<>(capacityPerStack * numStacks);
    }

    public void push(int stack, E element) {
        StackInfo meta = this.stacks[stack];

        if (meta.size == meta.capacity) {
            throw new RuntimeException();
        }

        buffer.set(meta.start + meta.size++, element);
    }

    public E pop(int stack) {
        StackInfo meta = stacks[stack];

        if (meta.size < 1) {
            throw new RuntimeException();
        }

        return buffer.get(meta.start + --meta.size);
    }

    public int size(int stack) {
        return stacks[stack].size;
    }
}
