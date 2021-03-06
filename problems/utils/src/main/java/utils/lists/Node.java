package utils.lists;

public final class Node<E> implements Cloneable {
    private static final ConcurrentCycleDetector cycleDetector = new ConcurrentCycleDetector();

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

    public Node<E> get(int index) {
        Node<E> current = this;

        while (index > 0) {
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }

            current = current.next;
            index--;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException();
        }

        return current;
    }

    @Override
    public String toString() {
        checkCircle();
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

    /**
     * Deeply determine if two lists are the same
     *
     * @param o the other node
     * @return true if the lists are deeply equal
     */
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
        return super.hashCode();
    }

    private void checkCircle() {
        cycleDetector.clear();

        var builder = new StringBuilder();
        Node<E> head = this;

        builder.append("Node(");

        while (head != null) {

            if (cycleDetector.contains(head)) {
                builder.append(head.value);
                builder.append(")");

                var message = String.format("Loop detected in %s", builder);

                throw new RuntimeException(message);
            }

            builder.append(head.value);
            builder.append("->");

            cycleDetector.add(head);
            head = head.next;
        }
    }
}
