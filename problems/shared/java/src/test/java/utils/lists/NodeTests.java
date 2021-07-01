package utils.lists;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTests {
    @Test
    public void create() {
        Node<Integer> head = Node.of(1, 2, 3);

        assertNotNull(head);
        assertEquals(head.getValue(), 1);

        head = head.getNext();
        assertNotNull(head);
        assertEquals(head.getValue(), 2);

        head = head.getNext();
        assertNotNull(head);
        assertEquals(head.getValue(), 3);
    }

    @Test
    public void get() {
        Node<Integer> head = Node.of(1, 2, 3);

        assertEquals(head.get(0).getValue(), 1);
        assertEquals(head.get(1).getValue(), 2);
        assertEquals(head.get(2).getValue(), 3);

        assertThrows(IndexOutOfBoundsException.class, () -> System.out.println(head.get(3)));
    }

    @Test
    public void copy() {
        Node<Integer> list = Node.of(1, 2, 3);
        Node<Integer> copy = new Node<>(list);

        assertEquals(list, copy);
    }

    @Test
    public void equality() {
        Node<Integer> list1 = Node.of(1, 2, 3);
        Node<Integer> list2 = Node.of(1, 2, 3);
        Node<Integer> list3 = Node.of(2, 2, 3);

        assertEquals(list1, list2);
        assertNotEquals(list1, list3);
    }

    @Test
    public void string() {
        Node<Integer> list1 = Node.of(1, 2, 3);

        assertEquals("Node(1->2->3)", list1.toString());
    }
}
