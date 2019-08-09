def find_palindromic_substring(s: str) -> str:

    def is_palindrome(s: str, head: int, tail: int) -> bool:
        count = tail - head + 1

        # odd
        if count % 2 != 0:
            while head != tail:
                if s[head] == s[tail]:
                    tail -= 1
                    head += 1
                else:
                    return False
            return True

        # even
        while (head - tail) != 1:
            if s[head] == s[tail]:
                head += 1
                tail -= 1
            else:
                return False

        return s[head] == s[tail]

    max_head = 0
    max_tail = 0
    max_count = 0

    for current_head in range(0, len(s)):
        for current_tail in range(current_head, len(s)):
            if is_palindrome(s, current_head, current_tail):
                # determine if this palindrome is bigger than the one
                # previously recorded
                count = current_tail - current_head + 1
                if count > max_count:
                    max_count = count
                    max_head = current_head
                    max_tail = current_tail

    return s[max_head:max_tail + 1]
