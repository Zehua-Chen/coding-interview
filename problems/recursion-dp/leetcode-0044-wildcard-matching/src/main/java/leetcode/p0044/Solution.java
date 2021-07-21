package leetcode.p0044;

public class Solution {
    public boolean isMatch(String s, String p) {
        var table = new boolean[s.length() + 1][];

        for (int si = 0; si < table.length; si++) {
            table[si] = new boolean[p.length() + 1];
        }

        for (int si = table.length - 1; si >= 0; si--) {
            for (int pi = table[0].length - 1; pi >= 0; pi--) {
                if (si >= s.length() && pi >= p.length()) {
                    table[si][pi] = true;
                    continue;
                } else if (si >= s.length()) {
                    table[si][pi] = p.charAt(pi) == '*' && table[si][pi + 1];
                    continue;
                } else if (pi >= p.length()) {
                    table[si][pi] = false;
                    continue;
                }

                char pc = p.charAt(pi);

                if (pc == '?') {
                    table[si][pi] = table[si + 1][pi + 1];
                    continue;
                }

                if (pc == '*') {
                    boolean matches = false;

                    for (int i = 0; (si + i) < s.length() + 1; i++) {
                        if (table[si + i][pi + 1]) {
                            matches = true;
                            break;
                        }
                    }

                    table[si][pi] = matches;
                    continue;
                }

                table[si][pi] = pc == s.charAt(si) && table[si + 1][pi + 1];
            }
        }

        return table[0][0];
    }
}
