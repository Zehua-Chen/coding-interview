from typing import Optional


# Definition for singly-linked list.
class ListNode:

    def __init__(self, x: int=0) -> None:
        self.val = x
        self.next = None  # type: Optional[ListNode]

    @staticmethod
    def make_list(number: int) -> "ListNode":
        s = str(number)
        i = len(s) - 1
        curent = None
        head = None

        while i >= 0:
            value = int(s[i])

            if head is None:
                current = ListNode(value)
                head = current
            else:
                current.next = ListNode(value)
                current = current.next

            i -= 1

        assert current is not None
        assert head is not None

        return head

    def __str__(self) -> str:
        node = self  # type: Optional[ListNode]
        buffer = ""

        while node is not None:
            buffer += str(node.val)

            if node.next is not None:
                buffer += "->"

            node = node.next

        return buffer

    def __eq__(self, other: object) -> bool:
        other_list = None
        if isinstance(other, int):
            other_list = ListNode.make_list(other)
        elif isinstance(other, ListNode):
            other_list = other

        assert other_list is not None

        return self._compare(other_list)

    def _compare(self, other: "ListNode") -> bool:
        self_current = self  # type: Optional[ListNode]
        other_current = other  # type: Optional[ListNode]

        while True:
            if self_current is not None and other_current is not None:
                if self_current.val == other_current.val:
                    self_current = self_current.next
                    other_current = other_current.next
                    continue
                else:
                    return False
            elif self_current is None and other_current is None:
                return True
            else:
                return False


def add_two_nums(l1: ListNode, l2: ListNode) -> ListNode:
    head = None
    cursor = None

    l1_current = l1  # type: Optional[ListNode]
    l2_current = l2  # type: Optional[ListNode]
    carried = 0

    while l1_current is not None or l2_current is not None:
        l1_current_val = 0
        l2_current_val = 0

        if l1_current is not None:
            l1_current_val = l1_current.val

        if l2_current is not None:
            l2_current_val = l2_current.val

        val = l1_current_val + l2_current_val + carried

        if val >= 10:
            val -= 10
            carried = 1
        else:
            # breakpoint()
            carried = 0

        if head is None:
            head = ListNode(val)
            cursor = head
        else:
            cursor.next = ListNode(val)
            cursor = cursor.next

        if l1_current is not None:
            l1_current = l1_current.next

        if l2_current is not None:
            l2_current = l2_current.next

    # Handle overflow
    if carried > 0:
        assert cursor is not None
        cursor.next = ListNode(carried)

    assert head is not None

    return head
