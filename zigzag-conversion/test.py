import unittest
from convert import convert


class ZigZagConversionTests(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
        self.assertEqual(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI")

    def test_single_row(self) -> None:
        self.assertEqual(convert("abcd", 1), "abcd")

    def test_two_rows(self) -> None:
        self.assertEqual(convert("abcdef", 2), "acebdf")

    def test_empty(self) -> None:
        self.assertEqual(convert("", 3), "")


if __name__ == "__main__":
    unittest.main()
