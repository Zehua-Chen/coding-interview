import unittest
from find_sum import find_sum


class TestFindSum(unittest.TestCase):

    def test_simple(self) -> None:
        x, y = find_sum([2, 3, 4, 10], 7)

        if x == 1:
            self.assertEqual(y, 2)
            return

        if x == 2:
            self.assertEqual(y, 1)
            return

        self.fail()

    def test_simple2(self) -> None:
        x, y = find_sum([3, 2, 4], 6)

        if x == 1:
            self.assertEqual(y, 2)
            return

        if x == 2:
            self.assertEqual(y, 1)
            return

        self.fail()

    def test_negative(self) -> None:
        x, y = find_sum([-1, -2, -3, -4, -5], -8)

        if x == 4:
            self.assertEqual(y, 2)
            return

        if x == 2:
            self.assertEqual(y, 4)
            return

        self.fail()

    def test_mixed(self) -> None:
        x, y = find_sum([-1, 2, -3, 4, -6], 3)

        if x == 0:
            self.assertEqual(y, 3)
            return

        if x == 3:
            self.assertEqual(y, 0)
            return

        self.fail()

    def test_uniform(self) -> None:
        x, y = find_sum([3, 3], 6)

        self.assertEqual(x, 0)
        self.assertEqual(y, 1)


if __name__ == "__main__":
    unittest.main()
