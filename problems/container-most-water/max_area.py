from typing import List


def max_area(height: List[int]) -> int:
    max_area = 0

    for first_i, first_v in enumerate(height):
        for second_i, second_v in enumerate(height):
            w = second_i - first_i
            h = first_v if first_v < second_v else second_v

            area = w * h

            if max_area < area:
                max_area = area

    return max_area
