package cci.s3.p2;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class MinStackTests {
    public static Stream<Arguments> tests() {
        return Stream.of(arguments(new BaselineMinStack()), arguments(new LessSpaceMinStack()));
    }

    @ParameterizedTest
    @MethodSource("tests")
    public void test(MinStack stack) {
        // 1
        stack.push(1);

        // 1 2
        stack.push(2);

        assertEquals(1, stack.min());

        // 1
        assertEquals(2, stack.pop());

        // 1 100
        stack.push(100);

        // 1 100 0
        stack.push(0);

        assertEquals(0, stack.min());

        // 1 100
        assertEquals(0, stack.pop());
        assertEquals(1, stack.min());

        assertEquals(100, stack.pop());
        assertEquals(1, stack.min());

        assertEquals(1, stack.pop());
    }
}
