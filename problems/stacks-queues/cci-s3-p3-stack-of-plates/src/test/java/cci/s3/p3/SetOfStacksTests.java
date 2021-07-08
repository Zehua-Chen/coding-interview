package cci.s3.p3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class SetOfStacksTests {
    public static Stream<Arguments> tests() {
        return Stream.of(arguments(new BaselineSetOfStacks<Integer>(5)));
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void regular(SetOfStacks<Integer> stack) {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 9; i > -1; i--) {
            assertEquals(i, stack.pop());
        }
    }

    @Test
    public void removeAtIndex() {
        var stack = new RemoveAtIndexSetOfStacks<Integer>(2);

        // three plates
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }

        // [0, 1]
        // [2]
        // [4, 5]
        stack.popAt(1);

        var expectedNumbers = new Stack<Integer>();
        expectedNumbers.addAll(List.of(0, 1, 2, 4, 5));

        while (!expectedNumbers.isEmpty()) {
            assertEquals(expectedNumbers.pop(), stack.pop());
        }
    }
}
