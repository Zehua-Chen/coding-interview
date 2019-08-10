import unittest
from reverse import reverse


class ReverseIntegerTests(unittest.TestCase):
    def test_given(self) -> None:
        self.assertEqual(reverse(123), 321)
        self.assertEqual(reverse(-123), -21)
        self.assertEqual(reverse(120), 21)

if __name__ == "__main__":
    unittest.main()
