def find_palindromic_substring(s: str) -> str:
    max_head = 0
    max_tail = 0
    max_count = 0

    # center on letters

    for center in range(0, len(s)):
        head = center
        tail = center

        while head >= 0 and tail < len(s):
            if s[head] == s[tail]:
                count = tail - head + 1

                if count > max_count:
                    max_count = count
                    max_head = head
                    max_tail = tail
            else:
                break

            head -= 1
            tail += 1

    # center between letters

    for left_center in range(0, len(s) - 1):
        right_center = left_center + 1

        while left_center >= 0 and right_center < len(s):
            if s[left_center] == s[right_center]:
                count = right_center - left_center + 1

                if count > max_count:
                    max_count = count
                    max_head = left_center
                    max_tail = right_center
            else:
                break

            left_center -= 1
            right_center += 1

    return s[max_head:max_tail + 1]
