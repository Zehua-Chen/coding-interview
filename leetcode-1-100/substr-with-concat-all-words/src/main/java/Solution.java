import java.util.*;

public class Solution {
    /**
     * Determine if a substring contains each of the words
     * @param substring the substring to inspect
     * @param words the words to search for
     * @param result if each word is present, if words[i] is present, result.get(i) is true
     */
    public void contains(String substring, String[] words, List<Boolean> result) {
        for (var i = 0; i < words.length; i++) {
            if (result.get(i)) {
                continue;
            }

            String word = words[i];

            if (!substring.startsWith(word)) {
                continue;
            }

            result.set(i, true);

            contains(substring.substring(word.length()), words, result);
            break;
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        var output = new ArrayList<Integer>();
        var totalLength = words.length * words[0].length();

        var start = 0;
        var end = totalLength - 1;

        while (end < s.length()) {
            String sub = s.substring(start, end + 1);
            var results = new ArrayList<>(Collections.nCopies(words.length, false));

            contains(sub, words, results);

            if (results.stream().allMatch((result) -> result)) {
                output.add(start);
            }

            start += 1;
            end += 1;
        }

        return output;
    }
}
