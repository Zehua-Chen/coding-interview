package cci.s1.p5;

public class SinglePassSolution extends Solution {
    @Override
    public boolean areOneEditAway(String a, String b) {
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
                aIndex++;
                bIndex++;
                differences++;
            }
        }

        return differences <= 1;
    }
}
