import unittest
from add_two_nums import add_two_nums, ListNode


class TestListNode(unittest.TestCase):

    def test_not_equal(self):
        head_a = ListNode.make_list(243)
        head_b = ListNode.make_list(564)

        self.assertNotEqual(head_a, head_b)

    def test_equal(self):
        head_a = ListNode.make_list(243)
        head_b = ListNode.make_list(243)

        self.assertEqual(head_a, head_b)


class TestAddTwoNumbers(unittest.TestCase):

    def test_utilities(self):
        head_a = ListNode.make_list(243)
        head_b = ListNode.make_list(564)

        # self.fail()


if __name__ == "__main__":
    unittest.main()
