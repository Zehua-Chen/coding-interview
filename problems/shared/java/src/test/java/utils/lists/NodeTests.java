package utils.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
