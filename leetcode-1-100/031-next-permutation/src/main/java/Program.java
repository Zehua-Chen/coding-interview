import java.util.*;

public class Program {
    public static void test(int[] input, int[] expected) {
        Solution solution = new Solution();

        solution.nextPermutation(input);

        if (!Arrays.equals(input, expected)) {
            System.out.printf(
                    "failed, expected %s, got %s\n",
                    Arrays.toString(expected), Arrays.toString(input));
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        test(new int[]{3, 2, 1}, new int[]{1, 2, 3});
        test(new int[]{1, 1, 5}, new int[]{1, 5, 1});
        test(new int[]{1, 3, 2}, new int[]{2, 1, 3});
        test(new int[]{2, 3, 1}, new int[]{3, 1, 2});
        test(new int[]{2, 3, 1, 3, 3}, new int[]{2, 3, 3, 1, 3});
    }
}
