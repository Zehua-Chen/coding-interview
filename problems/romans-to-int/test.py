from convert import convert
import unittest


class RomansToInteger(unittest.TestCase):
    def test_given(self):
        self.assertEqual(convert("III"), 3)
        self.assertEqual(convert("IV"), 4)
        self.assertEqual(convert("IX"), 9)
        self.assertEqual(convert("LVIII"), 58)
        self.assertEqual(convert("MCMXCIV"), 1994)

    def test_edge(self):
        self.assertEqual(convert("I"), 1)
        self.assertEqual(convert("MMMCMXCIX"), 3999)

if __name__ == "__main__":
    unittest.main()
