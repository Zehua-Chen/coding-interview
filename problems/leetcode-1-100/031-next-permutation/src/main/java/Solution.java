import java.util.*;

public class Solution {
    /**
     * Swap two elements in an array
     *
     * @param numbers the array where the elements are
     * @param a       index of the first element
     * @param b       index of the second element
     */
    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    /**
     * Reverse an array from a given index to the end of the array
     *
     * @param numbers the array to reverse
     * @param start   the start index to reverse
     */
    private void reverse(int[] numbers, int start) {
        if (numbers.length == 0 || numbers.length == 1) {
            return;
        }

        int head = start;
        int tail = numbers.length - 1;

        while (head <= tail) {
            swap(numbers, head, tail);
            head++;
            tail--;
        }
    }

    /**
     * From tail to head, find the first number that is not in descending order; Ex, given
     * [1, 2, 3, 4, 3, 1], return 2
     *
     * @param numbers the array to work with
     * @return the index of the found number
     */
    private int notDescending(int[] numbers) {
        int after = numbers[numbers.length - 1];

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] < after) {
                return i;
            }

            after = numbers[i];
        }

        return -1;
    }

    /**
     * Find the last minimum bigger number of a given number after an index
     *
     * @param numbers     the array to inspect
     * @param targetIndex the index of the number for which to find the least bigger number
     * @param startIndex  index from where to find the least bigger number
     * @return the index of the found number
     */
    private int lastMinBiggerAfter(int[] numbers, int targetIndex, int startIndex) {
        int bestIndex = -1;

        for (int i = startIndex; i < numbers.length; i++) {
            if (numbers[i] > numbers[targetIndex]) {
                if (bestIndex == -1) {
                    bestIndex = i;
                    continue;
                }

                if (numbers[i] <= numbers[bestIndex]) {
                    bestIndex = i;
                }
            }
        }

        return bestIndex;
    }

    public void nextPermutation(int[] numbers) {
        int outOfOrderIndex = notDescending(numbers);

        if (outOfOrderIndex == -1) {
            Arrays.sort(numbers);
            return;
        }

        int leastBiggerIndex = lastMinBiggerAfter(numbers, outOfOrderIndex, outOfOrderIndex);
        assert leastBiggerIndex >= 0;

        swap(numbers, outOfOrderIndex, leastBiggerIndex);
        reverse(numbers, outOfOrderIndex + 1);
    }
}
