package cci.s1.p4;

import java.util.*;

public class BaselineSolution extends Solution {
    @Override
    public boolean isPalindromePermutation(String string) {
        char[] letters = string.toLowerCase().toCharArray();
        Arrays.sort(letters);

        boolean foundOdd = false;

        int i = 0;

        while (i < letters.length) {
            int count = 0;
            char start = letters[i];
            count++;

            if (start == ' ') {
                i += count;
                continue;
            }

            while (i + count < letters.length && start == letters[i + count]) {
                count++;
            }

            i += count;

            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }

                foundOdd = true;
            }
        }

        return true;
    }
}
