class DecimalState {
    public boolean dot = false;
    public int digits = 0;

    public boolean isDecimal() {
        // decimal must have at least one digit and must have seen a dot
        return dot && digits > 0;
    }
}

class IntegerState {
    public int digits = 0;

    public boolean isInteger() {
        // integer must have at least one digit
        return digits > 0;
    }
}

public class Solution {
    private boolean isInteger(String s, int start, boolean e) {
        if (start >= s.length()) {
            return false;
        }

        int i = start;
        var state = new IntegerState();

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }

        for (; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!Character.isDigit(c)) {
                if ((c == 'e' || c == 'E') && e) {
                    return isInteger(s, i + 1, false) && state.isInteger();
                }

                return false;
            }

            state.digits++;
        }

        return state.isInteger();
    }

    private boolean isDecimal(String s, int start, boolean e) {
        if (start >= s.length()) {
            return false;
        }

        int i = start;
        var state = new DecimalState();

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c == '.') {
                state.dot = true;
                break;
            }

            if ((c == 'e' || c == 'E') && e) {
                return isInteger(s, i, false) && state.isDecimal();
            }

            if (!Character.isDigit(c)) {
                return false;
            }

            state.digits++;
        }

        while (i < s.length()) {
            char c = s.charAt(i++);

            if ((c == 'e' || c == 'E') && e) {
                return isInteger(s, i, false) && state.isDecimal();
            }

            if (!Character.isDigit(c)) {
                return false;
            }

            state.digits++;
        }

        return state.isDecimal();
    }

    public boolean isNumber(String s) {
        return isInteger(s, 0, true) || isDecimal(s, 0, true);
    }
}
