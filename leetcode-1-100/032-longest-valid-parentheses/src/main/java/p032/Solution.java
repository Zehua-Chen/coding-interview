package p032;

public class Solution {
    private int longest(String s, int location, int depth) {
        if (location == s.length()) {
            return depth == 0 ? 0 : -1;
        }

        if (s.charAt(location) == '(') {
            depth += 1;
        } else {
            depth -= 1;
        }

        if (depth < 0) {
            return 0;
        }

        if (depth > 0) {
            int length = longest(s, location + 1, depth);

            if (length == -1) {
                return -1;
            }

            return length + 1;
        }

        int length = longest(s, location + 1, 0);

        if (length == -1) {
            return 1;
        }

        return length + 1;
    }

    public int longestValidParentheses(String s) {
        int best = 0;

        for (int i = 0; i < s.length(); i++) {
            int child = longest(s, i, 0);

            if (child > best) {
                best = child;
            }
        }

        return best;
    }
}
