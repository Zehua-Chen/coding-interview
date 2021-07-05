package cci.s2.p4;

import java.util.function.*;

import utils.lists.Node;

import static java.lang.System.*;

public class Program {
    static void test(
            Node<Integer> head, int partition, int[] fronts, int[] backs, Solution solution) {
        Node<Integer> actual = solution.partition(new Node<>(head), partition);
        assert actual != null;

        Consumer<Integer> error =
                (item) -> {
                    out.printf(
                            "(%s) input = %s, partition = %d, %d not found in %s\n",
                            solution.getClass().getName(), head, partition, item, actual);
                    System.exit(-1);
                };

        for (int front : fronts) {
            boolean found = false;

            for (int j = 0; j < fronts.length; j++) {
                if (actual.get(j).getValue() == front) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                error.accept(front);
            }
        }

        for (int back : backs) {
            boolean found = false;

            for (int j = fronts.length; j < fronts.length + backs.length; j++) {
                if (actual.get(j).getValue() == back) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                error.accept(back);
            }
        }
    }

    static void test(Node<Integer> head, int partition, int[] fronts, int[] backs) {
        var solutions = new Solution[]{new ThreePassSolution(), new SwapSolution()};

        for (Solution solution : solutions) {
            test(head, partition, fronts, backs, solution);
        }
    }

    public static void main(String[] args) {
        test(Node.of(3, 5, 8, 5, 10, 2, 1), 5, new int[]{3, 1, 2}, new int[]{10, 5, 5, 8});
    }
}
