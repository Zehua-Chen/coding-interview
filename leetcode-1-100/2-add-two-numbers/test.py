import unittest
from add_two_nums import add_two_nums, ListNode


class TestListNode(unittest.TestCase):

    def test_not_equal(self) -> None:
        head_a = ListNode.make_list(243)
        head_b = ListNode.make_list(564)

        self.assertNotEqual(head_a, head_b)

    def test_equal(self) -> None:
        head_a = ListNode.make_list(243)
        head_b = ListNode.make_list(243)

        self.assertEqual(head_a, head_b)

    def test_equal_int(self) -> None:
        head = ListNode.make_list(243)
        self.assertEqual(head, 243)


class TestAddTwoNumbers(unittest.TestCase):

    def test_same_length(self) -> None:
        head_a = ListNode.make_list(243)
        head_b = ListNode.make_list(564)

        result = add_two_nums(head_a, head_b)

        self.assertEqual(result, 807)

    def test_diff_length(self) -> None:
        head_a = ListNode.make_list(1)
        head_b = ListNode.make_list(99)

        result = add_two_nums(head_a, head_b)

        self.assertEqual(result, 100)

    def test_overflow(self) -> None:
        head_a = ListNode.make_list(5)
        head_b = ListNode.make_list(5)

        result = add_two_nums(head_a, head_b)

        self.assertEqual(result, 10)


if __name__ == "__main__":
    unittest.main()
