package cci.s2.p1;

import utils.lists.Node;

import static java.lang.System.*;

public class Program {
    static void test(Node<Integer> input, Node<Integer> expected, Solution solution) {
        Node<Integer> actual = new Node<>(input);
        solution.removeDuplicates(actual);

        if (!actual.equals(expected)) {
            out.printf(
                    "(%s): input = %s, actual = %s, expected = %s\n",
                    solution.getClass().getName(), input, actual, expected);
        }
    }

    static void test(Node<Integer> input, Node<Integer> expected) {
        var solutions = new Solution[] {new BaselineSolution(), new NoBufferSolution()};

        for (Solution solution : solutions) {
            test(input, expected, solution);
        }
    }

    public static void main(String[] args) {
        test(Node.of(1, 2, 3), Node.of(1, 2, 3));
        test(Node.of(1, 1, 1, 2, 3, 3), Node.of(1, 2, 3));
        test(Node.of(1, 2, 1), Node.of(1, 2));
        test(Node.of(1, 1, 1), Node.of(1));
    }
}
