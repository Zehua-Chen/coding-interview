import unittest
from is_palindrome import is_palindrome


class PalindromeNumberTests(unittest.TestCase):
    def test_given(self):
        self.assertTrue(is_palindrome(121))
        self.assertFalse(is_palindrome(-121))
        self.assertFalse(is_palindrome(10))

    def test_zero(self):
        self.assertTrue(is_palindrome(0))

if __name__ == "__main__":
    unittest.main()
