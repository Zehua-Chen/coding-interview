class Solution {
    private String full(ArrayList<String> words, int widthOfWordsOfLine, int maxWidth) {
        assert words.size() > 0;

        if (words.size() == 1) {
            return leftJustify(words, maxWidth);
        }

        int remainingWidth = maxWidth - widthOfWordsOfLine;
        int separatorCount = words.size() - 1;

        int widthPerSeparator = remainingWidth / separatorCount;
        int extraWidth = remainingWidth - widthPerSeparator * separatorCount;

        var line = new StringBuilder();

        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);
            line.append(word);

            int extra = extraWidth > 0 ? 1 : 0;

            for (int j = 0; j < widthPerSeparator + extra; j++) {
                line.append(" ");
            }

            extraWidth = Math.max(extraWidth - 1, 0);
        }

        line.append(words.get(words.size() - 1));

        return line.toString();
    }

    private String leftJustify(ArrayList<String> words, int maxWidth) {
        var line = new StringBuilder();
        line.append(String.join(" ", words));

        int remain = maxWidth - line.length();

        for (int i = 0; i < remain; i++) {
            line.append(" ");
        }

        return line.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        var lines = new ArrayList<String>();
        var wordsOfLine = new ArrayList<String>();
        int widthOfWordsOfLine = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            int newSpaces = wordsOfLine.size();
            int newWidthOfLine = newSpaces + widthOfWordsOfLine + word.length();

            if (newWidthOfLine <= maxWidth) {
                wordsOfLine.add(word);
                widthOfWordsOfLine += word.length();
                continue;
            }

            lines.add(full(wordsOfLine, widthOfWordsOfLine, maxWidth));

            wordsOfLine.clear();
            widthOfWordsOfLine = 0;

            wordsOfLine.add(word);
            widthOfWordsOfLine += word.length();
        }

        if (wordsOfLine.size() > 0) {
            lines.add(leftJustify(wordsOfLine, maxWidth));
        }

        return lines;
    }
}
