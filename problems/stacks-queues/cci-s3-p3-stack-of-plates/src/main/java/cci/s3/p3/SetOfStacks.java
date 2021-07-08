package cci.s3.p3;

public interface SetOfStacks<E> {
    void push(E element);

    E pop();
}
