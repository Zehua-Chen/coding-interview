class Solution {
  public int divide(int divident, int divisor) {
    // Handle overflow conditions
    if (divident == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    // The trivial solution would be to keep subtracing the divisor from the divident. However
    // this method is too slow
    //
    // This solution improves on the previous solution by keeping multiplying the divisor by
    // 2 (implemented using << 1) and then subtracting the divisor from the divident.
    //
    // There is an inner loop because we are not subtracting (divisor * 2), but (divisor * 2^x)
    // where x is being incremented
    int absDivident = Math.abs(divident);
    int absDivisor = Math.abs(divisor);

    int result = 0;

    while (absDivident - absDivisor >= 0) {
      int x = 0;

      // Guard against making the divisor too big
      while (absDivident - ((absDivisor << x) << 1) >= 0) {
        x++;
      }

      result += (1 << x);
      absDivident -= (absDivisor << x);
    }

    if ((divident > 0) == (divisor > 0)) {
      return result;
    }

    return -result;
  }
}
