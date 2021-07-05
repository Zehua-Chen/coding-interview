package cci.s1.p2;

import java.util.*;

public class Solution {
    /**
     * Given two strings, decide if the candidate is the permutation of the original
     *
     * @param original  the original string
     * @param candidate the string that can be the permutation
     * @return true if candidate is the permutation of original
     */
    public boolean isPermutation(String original, String candidate) {
        char[] originalChars = original.toCharArray();
        char[] candidateChars = candidate.toCharArray();

        if (originalChars.length != candidateChars.length) {
            return false;
        }

        Arrays.sort(originalChars);
        Arrays.sort(candidateChars);

        for (int i = 0; i < originalChars.length; i++) {
            if (originalChars[i] != candidateChars[i]) {
                return false;
            }
        }

        return true;
    }
}
