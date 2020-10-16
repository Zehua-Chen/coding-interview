import java.util.*;

public class Solution {
    public static List<String> combinations(List<String> words) {
        if (words.size() == 1) {
            return List.of(words.stream().findFirst().get());
        }

        var output = new ArrayList<String>();

        for (var i = 0; i < words.size(); i++) {
            String word = words.get(i);
            var wordsCopy = new ArrayList<>(words);
            wordsCopy.remove(i);

            List<String> children = combinations(wordsCopy);

            for (String child : children) {
                output.add(word + child);
            }

            wordsCopy.add(word);
        }

        return output;
    }

    public static List<Integer> all(String s, String segment) {
        var list = new ArrayList<Integer>();
        var current = s.indexOf(segment);

        while (current != -1) {
            list.add(current);
            current = s.indexOf(segment, current + 1);
        }

        return list;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<String> segments = combinations(Arrays.asList(words));
        var output = new HashSet<Integer>();

        for (String segment : segments) {
            List<Integer> found = all(s, segment);
            output.addAll(found);
        }

        return new ArrayList<>(output);
    }
}
