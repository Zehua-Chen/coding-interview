import unittest
from find_sum import find_sum

class TestFindSum(unittest.TestCase):
    
    def test_simple(self) -> None:
        x, y = find_sum([2, 3, 4], 7)
    
    
if __name__ == "__main__":
    unittest.main()