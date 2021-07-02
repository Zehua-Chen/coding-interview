package cci.s2.p5;

import utils.lists.Node;

import static java.lang.System.*;

public class Program {
    static void test(Node<Integer> a, Node<Integer> b, Node<Integer> expected, Solution solution) {
        Node<Integer> actual = solution.add(a, b);
        assert actual != null;

        if (!actual.equals(expected)) {
            err.printf(
                    "(%s) a = %s, b = %s, actual = %s, expected = %s\n",
                    solution.getClass().getName(), a, b, actual, expected);
        }
    }

    public static void main(String[] args) {
        // reverse order
        test(Node.of(7, 1, 6), Node.of(5, 9, 2), Node.of(2, 1, 9), new ReverseSolution());
        test(Node.of(7, 1, 6), Node.of(5, 9, 2, 1), Node.of(2, 1, 9, 1), new ReverseSolution());
        test(Node.of(7, 1, 6, 1), Node.of(5, 9, 2), Node.of(2, 1, 9, 1), new ReverseSolution());
    }
}
