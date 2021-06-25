package cci.s1.p6;

public class BaselineSolution implements Solution {
    public String compress(String raw) {
        // a slightly different approach is to
        // 1. count the resulting compression length first
        // 2. decide if compression is needed
        // 3. if compression is needed, reserve enough space in string builder
        int i = 0;
        var builder = new StringBuilder();

        while (i < raw.length()) {
            char head = raw.charAt(i++);
            int count = 1;

            while (i < raw.length() && head == raw.charAt(i)) {
                count++;
                i++;
            }

            builder.append(head);
            builder.append(count);
        }

        String compressed = builder.toString();

        if (compressed.length() >= raw.length()) {
            return raw;
        }

        return compressed;
    }
}
