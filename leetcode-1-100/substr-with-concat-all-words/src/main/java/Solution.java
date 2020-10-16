import java.util.*;

public class Solution {
    public static List<String> combinations(Set<String> words) {
        if (words.size() == 1) {
            return List.of(words.stream().findFirst().get());
        }

        var output = new ArrayList<String>();
        var wordsCopy = new HashSet<>(words);

        for (String word : words) {
            wordsCopy.remove(word);
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
            current = s.indexOf(segment, current + segment.length());
        }

        return list;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> segments = combinations(new HashSet<>(Arrays.asList(words)));
        var output = new ArrayList<Integer>();

        for (String segment : segments) {
            System.out.println(segment);
            List<Integer> found = all(s, segment);
            output.addAll(found);
        }

        return output;
    }
}
