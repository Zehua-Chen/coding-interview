package cci.s1.p3;

import java.util.*;

public class Solution {
    public char[] urlify(char[] s, int length) {
        var buffer = new LinkedList<Character>();

        for (int i = 0; i < length; i++) {
            char c = s[i];

            if (c == ' ') {
                buffer.add('%');
                buffer.add('2');
                buffer.add('0');

                continue;
            }

            buffer.add(c);
        }

        assert buffer.size() <= s.length;

        for (int i = 0; i < s.length; i++) {
            s[i] = buffer.pop();
        }

        return s;
    }
}
