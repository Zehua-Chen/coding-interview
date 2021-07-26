package leetcode.p0049;

import java.util.*;

/**
 * Baseline solution runs in O(N) time, O(N) memory.
 *
 * <p>Takes advantage of the constraints 1. All chars are lower case English letters 2. The max
 * string length is 100
 */
public class OptimalSolution {
    private String createID(String s) {
        var letters = new char[26];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        return new String(letters);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        var idToIndices = new HashMap<String, Integer>();
        var anagrams = new ArrayList<List<String>>();

        for (String str : strs) {
            String id = createID(str);
            Integer index = idToIndices.get(id);

            if (index == null) {
                anagrams.add(new ArrayList<>());
                index = anagrams.size() - 1;

                idToIndices.put(id, index);
            }

            anagrams.get(index).add(str);
        }

        return anagrams;
    }
}
