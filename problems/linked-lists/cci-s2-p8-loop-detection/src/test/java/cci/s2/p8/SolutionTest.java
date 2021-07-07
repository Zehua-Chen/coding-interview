package cci.s2.p8;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import utils.lists.Node;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class SolutionTest {
    public static Arguments loop() {
        var head = Node.of(1, 2, 3, 4);
        var tail = head.get(3);
        var loop = head.get(1);
        tail.setNext(loop);

        return arguments(head, loop);
    }

    public static Arguments noLoop() {
        return arguments(Node.of(1, 2, 3), null);
    }

    public static Stream<Arguments> tests() {
        return Stream.of(loop(), noLoop());
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void baseline(Node<Integer> list, Node<Integer> loopHead) {
        var solution = new BaselineSolution();
        assertSame(loopHead, solution.findLoopHead(list));
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void twoPointer(Node<Integer> list, Node<Integer> loopHead) {
        var solution = new TwoPointerSolution();
        assertSame(loopHead, solution.findLoopHead(list));
    }
}
