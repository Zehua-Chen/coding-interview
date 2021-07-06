package cci.s2.p6;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import utils.lists.Node;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class SolutionTests {
    public static Stream<Arguments> tests() {
        return Stream.of(
                arguments(Node.of('a', 'b'), false),
                arguments(Node.of('a', 'b', 'a'), true),
                arguments(Node.of('a', 'b', 'b', 'a'), true),
                arguments(Node.of('a', 'b', 'a', 'a', 'b', 'a'), true));
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void reverse(Node<Character> head, boolean isPalindrome) {
        var solution = new ReverseSolution();
        assertEquals(isPalindrome, solution.isPalindrome(head));
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void stack(Node<Character> head, boolean isPalindrome) {
        var solution = new StackSolution();
        assertEquals(isPalindrome, solution.isPalindrome(head));
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void twoPointer(Node<Character> head, boolean isPalindrome) {
        var solution = new TwoPointerSolution();
        assertEquals(isPalindrome, solution.isPalindrome(head));
    }
}
