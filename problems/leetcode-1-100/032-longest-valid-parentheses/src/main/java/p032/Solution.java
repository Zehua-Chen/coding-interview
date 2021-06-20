package p032;

import java.util.*;

public class Solution {
    public int longestValidParentheses(String s) {
        var maxLength = 0;
        // we use a stack and its push and pop operation to remember the index before which a
        // substring starts (the peek)
        //
        // For example, after ((), we would have [-1, 0] and i = 2, we know the substring starts
        // at (0 + 1), and therefore have length (2 - 0) = 2
        var stack = new Stack<Integer>();

        // We need -1 so that if an entire string is well formed (which would give [-1] stack in
        // the end), we can still calculate the length
        stack.push(-1);

        for (var i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // each ( can be the index before the start of a well formed substring
                stack.push(i);
            } else {
                // after pop, we would know the index before the start of the well-formed substring
                // that can be formed at i
                stack.pop();

                // in situations like ())... which would give [] at this point, we still need to
                // be able to know the index before the start of the well formed substring "..."
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    // make sure that only the longest is preserved
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}

