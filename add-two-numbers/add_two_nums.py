

# Definition for singly-linked list.
class ListNode:

    @staticmethod
    def make_list(number: int):
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

        return head

    def __init__(self, x=0):
        self.val = x
        self.next = None

    def __str__(self):
        node = self
        buffer = ""

        while node is not None:
            buffer += str(node.val)

            if node.next is not None:
                buffer += "->"

            node = node.next

        return buffer

    def __eq__(self, other):
        t = type(other)
        other_list = None
        if t is int:
            other_list = ListNode.make_list(other)
        elif t is ListNode:
            other_list = other

        return self._compare(other_list)

    def _compare(self, other):
        self_current = self
        other_current = other

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
    return ListNode()
