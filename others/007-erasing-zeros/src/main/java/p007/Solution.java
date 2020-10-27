package p007;

public class Solution {
    private int eraseZeros(String s, int start, int total) {
        // base case
        if (start >= s.length()) {
            return 0;
        }

        if (start == s.length() - 1) {
            if (s.charAt(start) == '0') {
                return 0;
            }

            return total;
        }

        // regular cases
        if (s.charAt(start) == '0') {
            return eraseZeros(s, start + 1, total + 1);
        }

        // consecutive calls may return -1
        return Math.max(total, eraseZeros(s, start + 1, total));
    }

    public int eraseZeros(String s) {
        var start = 0;

        for (; start < s.length(); start++) {
            if (s.charAt(start) == '1') {
                break;
            }
        }

        for (; start < s.length(); start++) {
            if (s.charAt(start) != '1') {
                break;
            }
        }

        return eraseZeros(s, start, 0);
    }
}
