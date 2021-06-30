package utils.lists;

import java.util.*;

public final class Node<E> implements Cloneable {
    private Node<E> next;
    private E value;

    @SafeVarargs
    public static <E> Node<E> of(E... values) {
        Node<E> root = new Node<>(values[0]);
        Node<E> prev = root;

        for (int i = 1; i < values.length; i++) {
            prev.next = new Node<>(values[i]);
            prev = prev.next;
        }

        return root;
    }

    public Node(E value) {
        this.value = value;
    }

    public Node(Node<E> other) {
        assert other != null;

        value = other.value;

        if (other.next != null) {
            next = new Node<>(other.next);
        }
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        assert value != null;
        this.value = value;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        builder.append("Node(");

        Node<E> head = this;

        while (head.next != null) {
            builder.append(head.value);
            builder.append("->");
            head = head.next;
        }

        builder.append(head.value);
        builder.append(")");

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;

        if (!value.equals(node.value)) {
            return false;
        }

        if (next == null && node.next == null) {
            return true;
        }

        if (next == null || node.next == null) {
            return false;
        }

        return next.equals(node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value);
    }
}
