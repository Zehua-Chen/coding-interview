from typing import List, Tuple


def find_sum(data: List[int], target: int) -> Tuple[int, int]:
    d = dict()

    # record values and their index for O(1) lookup
    for (i, val) in enumerate(data):
        d[val] = i

    for (i, val) in enumerate(data):
        # find the other value needed to make up the target
        diff = target - val
        # if the other value exists and is not the current value, return
        if diff in d and i != d[diff]:
            return (i, d[diff])

    # found nothing
    return (0, 0)
