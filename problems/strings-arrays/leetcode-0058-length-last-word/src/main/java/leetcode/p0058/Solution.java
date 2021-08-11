package leetcode.p0058;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                break;
            }

            i--;
        }

        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                break;
            }

            i--;
            length++;
        }

        return length;
    }
}
