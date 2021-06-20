def my_atoi(str: str) -> int:
    MAX = (2 ** 31) - 1
    MIN = -1 * (2 ** 31)

    sign = 1
    value = 0

    i = 0

    if len(str) == 0:
        return 0

    while i < len(str) and str[i] == " ":
        i += 1

    if i >= len(str):
        return 0

    if str[i] == "+":
        sign = 1
        i += 1
    elif str[i] == "-":
        sign = -1
        i += 1
    elif str[i].isalpha():
        return 0

    if i >= len(str):
        return 0

    while i < len(str) and str[i].isnumeric():
        v = int(str[i])
        value *= 10
        value += v
        i += 1

    value *= sign

    if value > MAX:
        return MAX
    elif value < MIN:
        return MIN
    else:
        return value


if __name__ == "__main__":
    print(my_atoi("  -12abc"))
    print(my_atoi("abc-12"))
