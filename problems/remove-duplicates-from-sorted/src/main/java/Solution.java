public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return 0;
    }

    if (nums.length == 0) {
      return 0;
    }

    // The high level idea here is that we can modify the old array in place
    // as if it is a new array, because the we only look at the "old" index
    // and anything past the old index, so modifying the values before the old
    // index, i.e. the new index (since we are outputing an array of
    // unique values, the output array would always be smaller than the input
    // array) would not cause problems

    // the current in the "old" array
    int oldIndex = 1;

    // the current index in the new array
    int newIndex = 1;
    int prev = nums[0];

    while (oldIndex < nums.length) {
      if (nums[oldIndex] != prev) {
        nums[newIndex] = nums[oldIndex];
        newIndex++;
      }

      prev = nums[oldIndex];
      oldIndex++;
    }

    return newIndex;
  }
}
