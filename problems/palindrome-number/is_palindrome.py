def is_palindrome(x: int) -> bool:
    if x < 0:
        return False

    digits = []

    while x >= 10:
        digit = x % 10
        x -= digit
        x = int(x / 10)
        digits.append(digit)

    digits.append(x)

    head_index = 0
    tail_index = len(digits) - 1

    while head_index != tail_index and (head_index + 1) != tail_index:

        if digits[head_index] != digits[tail_index]:
            return False

        tail_index -= 1
        head_index += 1

    return digits[head_index] == digits[tail_index]
