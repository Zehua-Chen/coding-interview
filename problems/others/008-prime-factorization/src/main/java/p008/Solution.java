package p008;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> primeFactors(int number) {
        var result = new ArrayList<Integer>();

        if (number < 2) {
            return result;
        }

        for (var trial = 2; trial * trial <= number; trial++) {
            if ((number % trial) == 0) {
                List<Integer> smaller = primeFactors(trial);
                List<Integer> bigger = primeFactors(number / trial);

                result.addAll(smaller);
                result.addAll(bigger);

                break;
            }
        }

        if (result.isEmpty()) {
            result.add(number);
        }

        return result;
    }
}
