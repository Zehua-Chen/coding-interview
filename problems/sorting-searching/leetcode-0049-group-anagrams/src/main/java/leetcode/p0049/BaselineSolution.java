package leetcode.p0049;

import java.util.*;

/** Baseline solution runs in O(N log N) time, O(N) memory */
public class BaselineSolution {
    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        var sortedStrs = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            sortedStrs[i] = sort(strs[i]);
        }

        var anagrams = new ArrayList<List<String>>();
        var table = new HashMap<String, Integer>();

        for (int i = 0; i < sortedStrs.length; i++) {
            String sortedStr = sortedStrs[i];
            Integer anagramGroup = table.get(sortedStr);

            if (anagramGroup == null) {
                anagrams.add(new ArrayList<>());

                anagramGroup = anagrams.size() - 1;
                table.put(sortedStr, anagramGroup);
            }

            anagrams.get(anagramGroup).add(strs[i]);
        }

        return anagrams;
    }
}
