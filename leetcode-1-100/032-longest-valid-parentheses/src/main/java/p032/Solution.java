package p032;

import java.util.*;

public class Solution {
    private static class State {
        public int length;
        public int depth;

        public State() {
            this.length = -1;
            this.depth = -1;
        }
    }

    private State recursive(String s, int index) {
        char c = s.charAt(index);
        return null;
    }

    public int longestValidParentheses(String s) {
        int best = 0;

        for (var i = 0; i < s.length(); i++) {
            State state = recursive(s, i);

            if (state.length > best) {
                best = state.length;
            }
        }

        return best;
    }
}
