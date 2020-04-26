public class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }

    // Below expression is simplified, this is the actual expression
    // haystack.length() - 1 - needle.length() + 1
    int endIndex = haystack.length() - needle.length();

    // two strings has equal length
    if (endIndex == 0) {
      if (haystack.equals(needle)) {
        return 0;
      }

      return -1;
    }

    for (int i = 0; i < endIndex + 1; i++) {
      boolean found = true;

      for (int j = 0; j < needle.length(); j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          found = false;
          break;
        }
      }

      if (found) {
        return i;
      }
    }

    return -1;
  }
}
