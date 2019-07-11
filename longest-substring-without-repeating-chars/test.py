import unittest
from longest_subs import longest_subs


class TestLongestSubstringWithoutRepeatingChars(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(longest_subs("abcabcbb"), 3)
        self.assertEqual(longest_subs("bbbbb"), 1)
        self.assertEqual(longest_subs("pwwkew"), 3)
        self.assertEqual(longest_subs("dvdf"), 3)

    def test_empty(self) -> None:
        self.assertEqual(longest_subs(" "), 1)
        self.assertEqual(longest_subs("  "), 1)

if __name__ == "__main__":
    unittest.main()
