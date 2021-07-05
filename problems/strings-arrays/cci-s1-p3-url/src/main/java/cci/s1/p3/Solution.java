package cci.s1.p3;

public class Solution {
    public char[] urlify(char[] s, int length) {
        int write = s.length - 1;
        int read = length - 1;

        while (write >= 0) {
            char c = s[read--];

            if (c == ' ') {
                s[write--] = '0';
                s[write--] = '2';
                s[write--] = '%';

                continue;
            }

            s[write--] = c;
        }

        return s;
    }
}
