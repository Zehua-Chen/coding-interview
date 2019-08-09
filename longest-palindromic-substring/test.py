import unittest
from find_palindromic_substring import find_palindromic_substring


class FindLongestPalindromicSubstringTests(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(find_palindromic_substring("babad"), "bab")
        self.assertEqual(find_palindromic_substring("cbbd"), "bb")

    def test_nested(self) -> None:
        self.assertEqual(find_palindromic_substring("abacdcaba"), "abacdcaba")

if __name__ == "__main__":
    unittest.main()
