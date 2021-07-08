package cci.s3.p4;

import java.util.*;

public class MyQueue<E> {
    private final Stack<E> in = new Stack<>();
    private final Stack<E> out = new Stack<>();

    public void enqueue(E e) {
        in.push(e);
    }

    public E dequeue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.pop();
    }
}
