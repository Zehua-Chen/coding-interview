package cci.s1.p1;

import java.util.*;

public class Solution {
    public boolean areAllCharsUnique(String s) {
        if (s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
