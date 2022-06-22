public class IterativeSolution {
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        var table = new int[word1Length + 1][];

        for (int word1Index = 0; word1Index < table.length; word1Index++) {
            table[word1Index] = new int[word2Length + 1];
        }

        table[word1Length][word2Length] = 0;

        for (int word2Index = 0; word2Index < word2Length; word2Index++) {
            table[word1Length][word2Index] = word2Length - word2Index;
        }

        for (int word1Index = 0; word1Index < word1Length; word1Index++) {
            table[word1Index][word2Length] = word1Length - word1Index;
        }

        for (int word1Index = word1Length - 1; word1Index >= 0; word1Index--) {
            for (int word2Index = word2Length - 1; word2Index >= 0; word2Index--) {
                if (word1.charAt(word1Index) == word2.charAt(word2Index)) {
                    table[word1Index][word2Index] = table[word1Index + 1][word2Index + 1];
                    continue;
                }

                int insert = table[word1Index][word2Index + 1];
                int delete = table[word1Index + 1][word2Index];
                int update = table[word1Index + 1][word2Index + 1];

                table[word1Index][word2Index] = Math.min(Math.min(insert, delete), update) + 1;
            }
        }


        return table[0][0];
    }
}
