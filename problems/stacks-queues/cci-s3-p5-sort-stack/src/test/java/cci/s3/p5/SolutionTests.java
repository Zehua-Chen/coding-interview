package cci.s3.p5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class SolutionTests {
    public static Stream<Arguments> tests() {
        return Stream.of(arguments(new FinalSolution()));
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void test(Solution solution) {
        var stack = new Stack<Integer>();
        stack.addAll(List.of(3, 2, 1, 4));

        var expected = new Stack<Integer>();
        expected.addAll(List.of(4, 3, 2, 1));

        solution.sort(stack);

        assertEquals(expected, stack);
    }
}
