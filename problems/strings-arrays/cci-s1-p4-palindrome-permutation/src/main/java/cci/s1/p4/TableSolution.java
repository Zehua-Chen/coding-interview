package cci.s1.p4;

/**
 * Improved from `BaselineSolution`
 */
public class TableSolution extends Solution {
    static final int START = 'a';
    static final int END = 'z';

    @Override
    boolean isPalindromePermutation(String string) {
        int[] counts = new int[END - START + 1];
        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            int letterInt = ((int) letter) - START;

            if (letter == ' ') {
                continue;
            }

            counts[letterInt]++;
        }

        boolean foundOdd = false;

        for (int count : counts) {
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
