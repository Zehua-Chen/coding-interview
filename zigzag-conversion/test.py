import unittest
from convert import convert


class ZigZagConversionTests(unittest.TestCase):
    def test_given(self):
        self.assertEqual(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
        self.assertEqual(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI")

    def test_single_row(self):
        self.assertEqual(convert("abcd", 1), "abcd")

    def test_two_rows(self):
        self.assertEqual(convert("abcdef", 2), "acebdf")

    def test_empty(self):
        self.assertEqual(convert("", 3), "")


if __name__ == "__main__":
    unittest.main()
