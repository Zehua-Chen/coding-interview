package leetocde.p0050;

public class BaselineSolution implements Solution {
    @Override
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double result = x;

        for (int i = 1; i < Math.abs(n); i++) {
            result *= x;
        }

        if (n < 0) {
            return 1.0 / result;
        }

        return result;
    }
}
