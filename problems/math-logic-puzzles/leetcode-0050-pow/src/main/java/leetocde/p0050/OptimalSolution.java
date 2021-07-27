package leetocde.p0050;

/**
 * Based on "Basic Methods" in https://en.wikipedia.org/wiki/Exponentiation_by_squaring Assuming n
 * is even, observe that 2 ^ n = (2 ^ n) * (2 ^ n). We can save time by calculate (2 ^ n) once, and
 * then multiply it by itself. When n is odd, similar principle applies
 *
 * <p>Runtime: O(log n), assuming multiplication is constant space; otherwise, O((n log x) ^ k)
 * Space: O(log n)
 */
public class OptimalSolution implements Solution {
    @Override
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            // Integer.MIN_VALUE * -1 == Integer.MIN_VALUE
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (x * myPow(x, (n + 1) * -1));
            }

            return 1.0 / myPow(x, n * -1);
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            double result = myPow(x, n / 2);
            return result * result;
        }

        double result = myPow(x, n / 2);

        return x * result * result;
    }
}
