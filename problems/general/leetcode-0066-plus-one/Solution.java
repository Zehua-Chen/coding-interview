class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;

        digits[i]++;

        while (i > 0) {
            if (digits[i] != 10) {
                break;
            }

            digits[i] = 0;
            digits[i - 1]++;

            i--;
        }

        if (digits[0] == 10) {
            digits[0] = 0;

            var newDigits = new int[digits.length + 1];
            newDigits[0] = 1;

            System.arraycopy(digits, 0, newDigits, 1, digits.length);

            return newDigits;
        }

        return digits;
    }
}
