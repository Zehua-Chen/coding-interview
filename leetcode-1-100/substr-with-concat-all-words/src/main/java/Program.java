import java.util.*;

public class Program {
    public static void test(String s, String[] words, int[] expected) {
        var solution = new Solution();

        List<Integer> actualList = solution.findSubstring(s, words);
        assert actualList != null;

        var actualSet = new HashSet<>(actualList);

        var expectedSet = new HashSet<Integer>();

        for (int e : expected) {
            expectedSet.add(e);
        }

        if (!actualSet.equals(expectedSet)) {
            System.out.printf(
                    "expected = %s, actual = %s\n",
                    Arrays.toString(expectedSet.toArray()), Arrays.toString(actualSet.toArray()));
        }
    }

    public static void main(String[] args) {
        test("barfoothefoobarman", new String[] {"foo", "bar"}, new int[] {0, 9});

        test(
                "wordgoodgoodgoodbestword",
                new String[] {"word", "good", "best", "word"},
                new int[] {});

        test("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"}, new int[] {6, 9, 12});
    }
}
