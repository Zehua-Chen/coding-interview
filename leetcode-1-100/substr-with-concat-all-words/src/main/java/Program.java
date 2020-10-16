import java.util.*;

public class Program {
    public static void test(String s, String[] words, Integer[] expected) {
        var solution = new Solution();

        List<Integer> actualList = solution.findSubstring(s, words);
        assert actualList != null;

        var actualSet = new HashSet<>(actualList);
        var expectedSet = new HashSet<>(Arrays.asList(expected));

        if (!actualSet.equals(expectedSet) || actualList.size() != expected.length) {
            System.out.printf(
                    "expected = %s, actual = %s\n",
                    Arrays.toString(expected), Arrays.toString(actualList.toArray()));
        }
    }

    public static void main(String[] args) {
        test("barfoothefoobarman", new String[] {"foo", "bar"}, new Integer[] {0, 9});

        test(
                "wordgoodgoodgoodbestword",
                new String[] {"word", "good", "best", "word"},
                new Integer[] {});

        test("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"}, new Integer[] {6, 9, 12});

        test(
                "wordgoodgoodgoodbestword",
                new String[] {"word", "good", "best", "good"},
                new Integer[] {8});

        test("aaa", new String[] {"a", "a"}, new Integer[] {0, 1});
    }
}
