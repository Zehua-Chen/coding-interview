class AddResult {
    public char carry = '0';
    public char result = '0';
}

public class Solution {
    void add(char a, char b, AddResult result) {
        if (a == '0' && b == '0') {
            result.result = result.carry;
            result.carry = '0';

            return;
        }

        if (a == '1' && b == '1') {
            result.result = result.carry;
            result.carry = '1';

            return;
        }

        if (a == '1' || b == '1') {
            if (result.carry == '1') {
                result.carry = '1';
                result.result = '0';
            } else {
                result.carry = '0';
                result.result = '1';
            }
        }

    }

    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        var builder = new StringBuilder();
        var addResult = new AddResult();

        while (aIndex >= 0 && bIndex >= 0) {
            char aChar = a.charAt(aIndex--);
            char bChar = b.charAt(bIndex--);

            add(aChar, bChar, addResult);

            builder.append(addResult.result);
        }

        if (aIndex >= 0) {
            while (aIndex >= 0) {
                char aChar = a.charAt(aIndex--);
                add(aChar, '0', addResult);
                builder.append(addResult.result);
            }

        } else if (bIndex >= 0) {
            while (bIndex >= 0) {
                char bChar = b.charAt(bIndex--);
                add(bChar, '0', addResult);
                builder.append(addResult.result);
            }
        }

        if (addResult.carry == '1') {
            builder.append(addResult.carry);
        }

        return builder.reverse().toString();
    }
}
