import unittest
from find_palindromic_substring import find_palindromic_substring


class FindLongestPalindromicSubstringTests(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(find_palindromic_substring("babad"), "bab")
        self.assertEqual(find_palindromic_substring("cbbd"), "bb")

    def test_simple(self) -> None:
        self.assertEqual(find_palindromic_substring("abacab"), "bacab")

    def test_nested(self) -> None:
        self.assertEqual(find_palindromic_substring("abacdcaba"), "abacdcaba")

    # def test_long(self) -> None:
    #     input = ""

    #     for i in range(0, 1000):
    #         input += "a"

    #     self.assertEqual(find_palindromic_substring(input), input)

if __name__ == "__main__":
    unittest.main()
