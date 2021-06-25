package leetcode.p0038;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        int i = 0;
        var builder = new StringBuilder();

        while (i < prev.length()) {
            char head = prev.charAt(i);
            i++;
            int count = 1;

            while (i < prev.length() && head == prev.charAt(i)) {
                i++;
                count++;
            }

            builder.append(count);
            builder.append(head);
        }

        return builder.toString();
    }
}
