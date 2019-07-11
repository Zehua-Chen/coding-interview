from typing import Dict


def longest_subs(s: str) -> int:
    letter_info = dict()  # type: Dict[str, int]
    current_index = 0
    letter_count = 0
    letter_count_max = 0

    while current_index < len(s):
        letter = s[current_index]

        # if letter is found to be repetitve, drop the repeated letter
        # by jumping to the next of the repeated letter
        if letter in letter_info:
            current_index = letter_info[letter] + 1
            letter_info.clear()

            if letter_count > letter_count_max:
                letter_count_max = letter_count

            letter_count = 0
            continue

        letter_info[letter] = current_index
        current_index += 1
        letter_count += 1

    if letter_count > letter_count_max:
        letter_count_max = letter_count

    return letter_count_max
