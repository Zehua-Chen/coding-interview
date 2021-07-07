package utils;

/**
 * A wrapper class to enable the storage of objects like C++ pointers in hash containers, regardless
 * of their `equals` and `hashCode` implementation
 *
 * <p>Reference instances pointing to the same object will always equals and have the same hash code
 *
 * @param <T>
 */
public final class Reference<T> {
    private T reference;

    public Reference(T reference) {
        this.reference = reference;
    }

    public T getReference() {
        return reference;
    }

    public void setReference(T reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference<?> other = (Reference<?>) o;

        return reference == other.reference;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(reference);
    }
}
