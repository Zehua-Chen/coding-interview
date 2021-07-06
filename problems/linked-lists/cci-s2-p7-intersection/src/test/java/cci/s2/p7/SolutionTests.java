package cci.s2.p7;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import utils.lists.Node;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class SolutionTests {
    private static Arguments intersectsA() {
        var a = Node.of(1, 2, 3);
        var b = Node.of(1, 2, 3);

        var tail = Node.of(4, 5);

        a.setNext(tail);
        b.setNext(tail);

        return arguments(a, b, tail);
    }

    private static Arguments intersectsB() {
        var a = Node.of(1);
        var b = Node.of(2, 3);

        a.setNext(b);

        return arguments(a, b, b);
    }

    private static Arguments notIntersects() {
        var a = Node.of(1, 2, 3);
        var b = Node.of(1, 2, 3);

        return arguments(a, b, null);
    }

    public static Stream<Arguments> tests() {
        return Stream.of(intersectsA(), intersectsB(), notIntersects());
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void constantSpace(Node<Integer> a, Node<Integer> b, Node<Integer> intersectingNode) {
        var solution = new ConstantSpaceSolution();
        assertSame(intersectingNode, solution.intersects(a, b));
    }
}
