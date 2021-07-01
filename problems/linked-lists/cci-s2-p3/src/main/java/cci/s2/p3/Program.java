package cci.s2.p3;

import utils.lists.Node;

import static java.lang.System.*;

public class Program {
    static void test(
            Node<Integer> head, int middleIndex, Node<Integer> expected, Solution solution) {
        var actual = new Node<>(head);
        solution.removeMiddle(actual.get(middleIndex));

        if (!actual.equals(expected)) {
            out.printf(
                    "(%s) input = %s, actual = %s, expected = %s\n",
                    solution.getClass().getName(), head, actual, expected);
        }
    }

    static void test(Node<Integer> head, int middleIndex, Node<Integer> expected) {
        var solutions = new Solution[] {new FinalSolution()};

        for (Solution solution : solutions) {
            test(head, middleIndex, expected, solution);
        }
    }

    public static void main(String[] args) {
        test(Node.of(1, 2), 1, Node.of(1, 2));
        test(Node.of(1, 2, 3), 1, Node.of(1, 3));
        test(Node.of(1, 2, 3, 4), 1, Node.of(1, 3, 4));
    }
}
