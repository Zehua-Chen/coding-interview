import unittest
from convert import convert


class ZigZagConversionTests(unittest.TestCase):
    def test_given(self):
        self.assertEqual(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
        self.assertEqual(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI")


if __name__ == "__main__":
    unittest.main()
