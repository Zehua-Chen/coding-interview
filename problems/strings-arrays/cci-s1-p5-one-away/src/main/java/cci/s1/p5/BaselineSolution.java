package cci.s1.p5;

public class BaselineSolution extends Solution {
    boolean differentLength(String a, String b) {
        int aIndex = 0;
        int bIndex = 0;

        int differences = 0;

        while (aIndex < a.length() && bIndex < b.length()) {
            char aLetter = a.charAt(aIndex);
            char bLetter = b.charAt(bIndex);

            if (aLetter == bLetter) {
                aIndex++;
                bIndex++;
                continue;
            }

            if (bIndex + 1 < b.length() && aLetter == b.charAt(bIndex + 1)) {
                bIndex++;
                differences++;
            } else if (aIndex + 1 < a.length() && bLetter == a.charAt(aIndex + 1)) {
                aIndex++;
                differences++;
            } else {
                return false;
            }
        }

        return differences <= 1;
    }

    boolean sameLength(String a, String b) {
        int differences = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differences++;
            }
        }

        return differences <= 1;
    }

    @Override
    public boolean areOneEditAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        if (a.length() != b.length()) {
            return differentLength(a, b);
        }

        return sameLength(a, b);
    }
}
