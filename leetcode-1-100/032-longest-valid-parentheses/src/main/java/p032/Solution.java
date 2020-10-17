package p032;

public class Solution {
    private int longest(String s, int location, int depth, int length) {
        if (location == s.length()) {
            return depth == 0 ? length : 0;
        }

        length += 1;

        if (s.charAt(location) == '(') {
            depth += 1;
        } else {
            depth -= 1;
        }

        if (depth < 0) {
            return 0;
        }

        if (depth > 0) {
            return longest(s, location + 1, depth, length);
        }

        return longest(s, location + 1, 0, 0) + length;
    }

    public int longestValidParentheses(String s) {
        int best = 0;

        for (int i = 0; i < s.length(); i++) {
            int child = longest(s, i, 0, 0);

            if (child > best) {
                best = child;
            }
        }

        return best;
    }
}
