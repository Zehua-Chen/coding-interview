public class RecursiveSolution {
    public int minDistance(String word1, String word2) {
        var minDistance = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer word1Index, Integer word2Index) {
                if (word1Index == word1.length()) {
                    return word2.length() - word2Index;
                }

                if (word2Index == word2.length()) {
                    return word1.length() - word1Index;
                }

                if (word1.charAt(word1Index) == word2.charAt(word2Index)) {
                    return this.apply(word1Index + 1, word2Index + 1);
                }

                int delete = this.apply(word1Index + 1, word2Index);
                int update = this.apply(word1Index + 1, word2Index + 1);
                int insert = this.apply(word1Index, word2Index + 1);

                return Math.min(Math.min(delete, update), insert) + 1;
            }
        };

        return minDistance.apply(0, 0);
    }
}
