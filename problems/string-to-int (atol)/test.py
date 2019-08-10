import unittest
from atoi import my_atoi


class StringToIntegerAtolTests(unittest.TestCase):
    def test_given(self):
        self.assertEqual(my_atoi("42"), 42)
        self.assertEqual(my_atoi("    -42"), -42)
        self.assertEqual(my_atoi("4193 with words"), 4193)
        self.assertEqual(my_atoi("words and 987"), 0)
        self.assertEqual(my_atoi("-91283472332"), 0)


if __name__ == "__main__":
    unittest.main()
