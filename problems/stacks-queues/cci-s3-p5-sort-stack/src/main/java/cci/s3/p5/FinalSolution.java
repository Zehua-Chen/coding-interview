package cci.s3.p5;

import java.util.*;

public class FinalSolution implements Solution {
    @Override
    public void sort(Stack<Integer> stack) {
        var buffer = new Stack<Integer>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!buffer.isEmpty() && temp < buffer.peek()) {
                stack.push(buffer.pop());
            }

            // We don't need to transfer what we have just popped from buffer because in the next
            // iteration, they will be pushed to buffer without popping anything from buffer.

            buffer.push(temp);
        }

        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }
}
