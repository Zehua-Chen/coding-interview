from convert import convert
import unittest


class IntToRomansTest(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(convert(3), "III")
        self.assertEqual(convert(4), "IV")
        self.assertEqual(convert(9), "IX")
        self.assertEqual(convert(58), "LVIII")
        self.assertEqual(convert(1994), "MCMXCIV")

    def test_edge(self) -> None:
        self.assertEqual(convert(1), "I")
        self.assertEqual(convert(3999), "MMMCMXCIX")

if __name__ == "__main__":
    unittest.main()
