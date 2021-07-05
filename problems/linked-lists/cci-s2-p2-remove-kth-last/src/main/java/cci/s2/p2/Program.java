package cci.s2.p2;

import utils.lists.Node;

import static java.lang.System.*;

public class Program {
    static void test(Node<Integer> head, int k, Integer expected, Solution solution) {
        Integer actual = solution.findLast(head, k);

        if (actual == null || !actual.equals(expected)) {
            out.printf(
                    "(%s) head = %s, k = %d, actual = %d, expected = %d\n",
                    solution.getClass().getName(), head, k, actual, expected);
        }
    }

    static void test(Node<Integer> head, int k, Integer expected) {
        var solutions =
                new Solution[]{
                        new BaselineSolution(), new RecursiveSolution(), new IterativeSolution()
                };

        for (Solution solution : solutions) {
            test(head, k, expected, solution);
        }
    }

    public static void main(String[] args) {
        test(Node.of(1, 2, 3), 1, 3);
        test(Node.of(1, 2, 3), 2, 2);
        test(Node.of(1, 2, 3), 3, 1);
    }
}
