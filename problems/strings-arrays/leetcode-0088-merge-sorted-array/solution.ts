/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  let nums1Index = nums1.length - 1 - n;
  let nums2Index = nums2.length - 1;

  let writeIndex = nums1.length - 1;

  while (nums1Index >= 0 && nums2Index >= 0) {
    if (nums1[nums1Index] < nums2[nums2Index]) {
      nums1[writeIndex] = nums2[nums2Index];
      nums2Index--;
    } else {
      nums1[writeIndex] = nums1[nums1Index];
      nums1Index--;
    }

    writeIndex--;
  }

  while (nums2Index >= 0) {
    nums1[writeIndex] = nums2[nums2Index];
    writeIndex--;
    nums2Index--;
  }
}
