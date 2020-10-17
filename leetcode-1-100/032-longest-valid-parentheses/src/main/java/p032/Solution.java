package p032;

public class Solution {
    private int recursive(String s, int location, int depth) {
        System.out.printf("location = %d, depth = %d\n", location, depth);

        if (location == s.length()) {
            return depth == 0 ? 0 : -1;
        }

        if (s.charAt(location) == '(') {
            depth += 1;
        } else {
            depth -= 1;
        }

        if (depth < 0) {
            return -1;
        }

        if (depth > 0) {
            int length = recursive(s, location + 1, depth);

            if (length == -1) {
                return -1;
            }

            return length + 1;
        }

        int length = recursive(s, location + 1, 0);

        if (length == -1) {
            return 1;
        }

        return length + 1;
    }

    public int longestValidParentheses(String s) {
        var cache = new int[s.length() + 1][];

        for (int i = 0; i < cache.length; i++) {
            cache[i] = new int[s.length() + 1];

            for (int j = 0; j < s.length() + 1; j++) {
                cache[i][j] = -1;
            }
        }

        for (int location = s.length() - 1; location >= 0; location--) {
            for (int depth = s.length() - 1; depth >= 0; depth--) {
                int depthCopy = depth;

                if (s.charAt(location) == '(') {
                    depthCopy++;
                } else {
                    depthCopy--;
                }

                if (depthCopy < 0) {
                    cache[location][depth] = -1;
                    continue;
                }

                if (depthCopy > 0) {
                    int nextLength = cache[location + 1][depthCopy];

                    if (nextLength == -1) {
                        cache[location][depth] = -1;
                    } else {
                        cache[location][depth] = nextLength + 1;
                    }

                    continue;
                }

                int nextLength = cache[location + 1][0];

                if (nextLength == -1) {
                    cache[location][depth] = 1;
                    continue;
                }

                cache[location][depth] = nextLength + 1;
            }
        }

        var best = 0;

        for (int[] location : cache) {
            if (location[0] > best) {
                best = location[0];
            }
        }

        return best;
    }
}
