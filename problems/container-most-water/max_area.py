from typing import List


def max_area(height: List[int]) -> int:
    head_i = 0
    tail_i = len(height) - 1
    max_area = 0

    while head_i != tail_i:
        head_h = height[head_i]
        tail_h = height[tail_i]

        h = head_h if head_h < tail_h else tail_h
        w = tail_i - head_i

        area = h * w

        if max_area < area:
            max_area = area

        if head_h > tail_h:
            tail_i -= 1
        else:
            head_i += 1

    return max_area
