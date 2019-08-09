from typing import List


def find_median(nums1: List[int], nums2: List[int]) -> float:
    nums1_len = len(nums1)
    nums2_len = len(nums2)
    total_len = nums1_len + nums2_len

    # Handle empty cases

    if nums1_len == 0:
        half_index = int(nums2_len / 2)

        if nums2_len % 2 == 0:
            return (nums2[half_index - 1] + nums2[half_index]) / 2
        else:
            return nums2[half_index]
    elif nums2_len == 0:
        half_index = int(nums1_len / 2)

        if nums1_len % 2 == 0:
            return (nums1[half_index - 1] + nums1[half_index]) / 2
        else:
            return nums1[half_index]

    # Normal

    nums1_index = 0
    nums2_index = 0
    median = 0

    # Calculate middle point

    iter_count = int(total_len / 2) \
        if (total_len % 2) == 0 else int(total_len / 2) + 1

    while nums1_index < (nums1_len) and nums2_index < (nums2_len):
        if nums1[nums1_index] > nums2[nums2_index]:
            median = nums2[nums2_index]
            nums2_index += 1
        else:
            median = nums1[nums1_index]
            nums1_index += 1

        iter_count -= 1

        if iter_count == 0:
            if total_len % 2 == 0:
                one_over = 0

                if nums1_index < nums1_len and nums2_index < nums2_len:
                    one_over = nums1[nums1_index] \
                        if nums1[nums1_index] < nums2[nums2_index] \
                        else nums2[nums2_index]
                elif nums1_index < nums1_len:
                    one_over = nums1[nums1_index]
                elif nums2_index < nums2_len:
                    one_over = nums2[nums2_index]

                median = int((median + one_over) / 2)
            return median

    # When one array is depeleted

    while nums1_index < (nums1_len):
        median = nums1[nums1_index]
        nums1_index += 1
        iter_count -= 1

        if iter_count == 0:
            if total_len % 2 == 0:
                one_over = nums1[nums1_index]
                median = int((median + one_over) / 2)

            return median

    while nums2_index < (nums2_len):
        median = nums2[nums2_index]
        nums2_index += 1
        iter_count -= 1

        if iter_count == 0:
            if total_len % 2 == 0:
                one_over = nums2[nums2_index]
                median = int((median + one_over) / 2)

            return median

    return median
