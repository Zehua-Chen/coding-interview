package cci.s1.p4;

import java.util.*;

public class BaselineSolution extends Solution {
    public boolean isPalindromePermutation(String string) {
        char[] letters = string.toLowerCase().toCharArray();
        Arrays.sort(letters);

        boolean singleFound = false;

        int i = 0;

        while (i < letters.length) {
            char start = letters[i];
            i++;

            if (start == ' ') {
                continue;
            }

            boolean multiple = false;

            while (i < letters.length && start == letters[i]) {
                i++;
                multiple = true;
            }

            if (!multiple) {
                if (singleFound) {
                    return false;
                }

                singleFound = true;
            }
        }

        return true;
    }
}
