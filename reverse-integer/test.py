import unittest
from reverse import reverse


class ReverseIntegerTests(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(reverse(123), 321)
        self.assertEqual(reverse(-123), -321)
        self.assertEqual(reverse(120), 21)

    def test_10s(self) -> None:
        self.assertEqual(reverse(10), 1)

    def test_overflow(self) -> None:
        self.assertEqual(reverse(1534236469), 0)

if __name__ == "__main__":
    unittest.main()
