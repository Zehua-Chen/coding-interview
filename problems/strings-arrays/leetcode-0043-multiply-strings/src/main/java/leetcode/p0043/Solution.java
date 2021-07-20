package leetcode.p0043;

public class Solution {
    private void add(String s, int i, int carry, StringBuilder result) {
        while (i > 0) {
            i--;

            int num = (int) s.charAt(i) - (int) '0';
            int sum = num + carry;

            int digit = sum % 10;
            carry = (sum - digit) / 10;

            result.append(digit);
        }

        if (carry > 0) {
            result.append(carry);
        }
    }

    private String add(String a, String b) {
        var builder = new StringBuilder();

        int i = a.length();
        int j = b.length();

        int carry = 0;

        while (i > 0 && j > 0) {
            i--;
            j--;

            int num1 = (int) a.charAt(i) - (int) '0';
            int num2 = (int) b.charAt(j) - (int) '0';

            int sum = num1 + num2 + carry;

            int digit = sum % 10;
            carry = (sum - digit) / 10;

            // System.out.printf("digit = %d, sum = %d, carry = %d\n", digit, sum, carry);

            builder.append(digit);
        }

        if (i == 0 && j == 0) {
            if (carry != 0) {
                builder.append(carry);
            }
        } else if (i == 0) {
            add(b, j, carry, builder);
        } else {
            add(a, i, carry, builder);
        }

        builder.reverse();

        return builder.toString();
    }

    private String multiply(String s, int multiplier, int postZeros) {
        if (multiplier == 0) {
            return "0";
        }

        var builder = new StringBuilder();
        builder.append("0".repeat(postZeros));

        int carry = 0;
        int i = s.length();

        while (i > 0) {
            i--;
            int num = (int) s.charAt(i) - (int) '0';
            int product = num * multiplier + carry;

            int digit = product % 10;
            carry = (product - digit) / 10;

            builder.append(digit);
        }

        while (carry > 0) {
            builder.append(carry % 10);
            carry /= 10;
        }

        builder.reverse();
        return builder.toString();
    }

    public String multiply(String s1, String s2) {
        String result = "0";

        if (s1.equals("0") || s2.equals("0")) {
            return result;
        }

        for (int i = 0; i < s1.length(); i++) {
            int multiplier = (int) s1.charAt(i) - (int) '0';
            int postZeros = s1.length() - 1 - i;
            String product = multiply(s2, multiplier, postZeros);

            System.out.printf(
                    "multiplier = %d, product = %s, result = %s\n", multiplier, product, result);

            result = add(result, product);
        }

        return result;
    }
}
