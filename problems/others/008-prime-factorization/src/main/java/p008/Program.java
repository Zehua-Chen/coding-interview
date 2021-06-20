package p008;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void test(int number, List<Integer> expected) {
        var solution = new Solution();
        List<Integer> actual = solution.primeFactors(number);

        if (!actual.equals(expected)) {
            System.out.printf("number = %d, expected = %s, actual = %s\n", number, expected, actual);
        }
    }

    public static void main(String[] args) {
        test(1, new ArrayList<>());
        test(2, List.of(2));
        test(64, Collections.nCopies(6, 2));
        test(315, List.of(3, 3, 5, 7));
        test(997, List.of(997));
    }
}
