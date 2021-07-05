package cci.s1.p4;

public class BitVectorSolution extends Solution {
    int flip(int bits, int index) {
        int mask = 1 << index;
        int bitAtIndex = ((bits & mask) >>> index);

        if (bitAtIndex == 0) {
            bits |= mask;
        } else {
            bits &= ~mask;
        }

        return bits;
    }

    @Override
    boolean isPalindromePermutation(String string) {
        int bits = 0;
        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);

            if (letter == ' ') {
                continue;
            }

            bits = flip(bits, letter - 'a');
        }

        return ((bits - 1) & bits) == 0;
    }
}
