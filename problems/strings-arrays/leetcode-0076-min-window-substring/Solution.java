// test cases
// "cabwefgewcwaefgcf", "cae"
// "abc", "aabc"
class Solution {
    private Map<Character, Integer> createCharCount(String s) {
        var charCount = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = charCount.getOrDefault(c, 0);
            charCount.put(c, count + 1);
        }

        return charCount;
    }

    public String minWindow(String s, String t) {
        var windowCharCount = new HashMap<Character, Integer>();
        Map<Character, Integer> tCharCount = createCharCount(t);

        int left = 0;
        int right = 0;

        int bestLeft = -1;
        int bestRight = -1;
        int bestLength = -1;

        int formed = 0;

        while (right < s.length()) {
            char rightC = s.charAt(right);
            int rightCount = windowCharCount.getOrDefault(rightC, 0);

            windowCharCount.put(rightC, rightCount + 1);
            rightCount++;

            if (tCharCount.containsKey(rightC)) {
                if (rightCount == tCharCount.get(rightC)) {
                    formed++;
                }
            }

            while (left <= right && formed == tCharCount.size()) {
                if (bestLength == -1 || right - left + 1 < bestLength) {
                    bestLength = right - left + 1;
                    bestLeft = left;
                    bestRight = right;
                }

                char leftC = s.charAt(left);
                int leftCount = windowCharCount.get(leftC);

                windowCharCount.put(leftC, leftCount - 1);
                leftCount--;

                if (tCharCount.containsKey(leftC) && leftCount < tCharCount.get(leftC)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return bestLength == -1 ? "" : s.substring(bestLeft, bestRight + 1);
    }
}
