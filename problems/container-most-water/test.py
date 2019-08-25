from max_area import max_area
import unittest


class MaxAreaTests(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(max_area([1, 8, 6, 2, 5, 4, 8, 3, 7]), 49)

if __name__ == "__main__":
    unittest.main()
