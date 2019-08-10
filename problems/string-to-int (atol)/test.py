import unittest
from atoi import my_atoi


class StringToIntegerAtolTests(unittest.TestCase):
    def test_given(self):
        self.assertEqual(my_atoi("42"), 42)
        self.assertEqual(my_atoi("    -42"), -42)
        self.assertEqual(my_atoi("4193 with words"), 4193)
        self.assertEqual(my_atoi("words and 987"), 0)
        self.assertEqual(my_atoi("-91283472332"), -2147483648)

    def test_decimal(self):
        self.assertEqual(my_atoi("42.22"), 42)

    def test_sign(self):
        self.assertEqual(my_atoi("+-42.22"), 0)
        self.assertEqual(my_atoi("-42-"), -42)
        self.assertEqual(my_atoi("-"), 0)

    def test_whitespace(self):
        self.assertEqual(my_atoi("+0 12"), 0)
        self.assertEqual(my_atoi("   -42"), -42)
        self.assertEqual(my_atoi(""), 0)
        self.assertEqual(my_atoi("         "), 0)


if __name__ == "__main__":
    unittest.main()
