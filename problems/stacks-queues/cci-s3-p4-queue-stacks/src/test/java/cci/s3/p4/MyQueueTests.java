package cci.s3.p4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTests {
    @Test
    public void test() {
        var queue = new MyQueue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        queue.enqueue(4);

        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
    }
}
