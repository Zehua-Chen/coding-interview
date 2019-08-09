import unittest
from find_median import find_median


class FindMedianOfTwoArraysTest(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(find_median([1, 3], [2]), 2.0)
        self.assertEqual(find_median([1, 2], [3, 4]), 2.5)

    def test_diff_len(self) -> None:
        self.assertEqual(find_median([1, 10], [5, 6, 7, 100, 101]), 7)
        self.assertEqual(find_median([1, 10], [5, 6, 7, 100]), 6.5)
        self.assertEqual(find_median([1], [2, 3, 4, 5, 6]), 3.5)

    def test_neg(self) -> None:
        self.assertEqual(find_median([1, 2], [-1, 3]), 1.5)

    def test_empty(self) -> None:
        self.assertEqual(find_median([], [1, 2, 3]), 2)
        self.assertEqual(find_median([], [1, 2, 3, 4]), 2.5)

        self.assertEqual(find_median([1, 2, 3], []), 2)
        self.assertEqual(find_median([1, 2, 3, 4], []), 2.5)

if __name__ == "__main__":
    unittest.main()
