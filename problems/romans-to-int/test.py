from convert import convert
import unittest


class RomansToInteger(unittest.TestCase):
    def test_given(self):
        self.assertEqual(convert("III"), 3)
        self.assertEqual(convert("IV"), 4)
        self.assertEqual(convert("IX"), 9)
        self.assertEqual(convert("LVIII"), 48)
        self.assertEqual(convert("MCMXCIV"), 1994)

if __name__ == "__main__":
    unittest.main()
