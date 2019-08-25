def convert(num: int) -> str:
    values = [1000, 500, 100, 50, 10, 5, 1]
    symbols = {
        1: "I",
        5: "V",
        10: "X",
        50: "L",
        100: "C",
        500: "D",
        1000: "M",
    }

    specials = {
        4: "IV",
        9: "IX",
        40: "XL",
        90: "XC",
        400: "CD",
        900: "CM"
    }

    s = ""
    digits = list()
    multiplier = 1

    while num >= 10:
        digit = num % 10
        num -= digit
        num = int(num / 10)
        digits.append(digit * multiplier)
        multiplier *= 10

    digits.append(num * multiplier)
    digits.reverse()

    for digit in digits:
        if digit in specials:
            s += specials[digit]
            continue

        values_i = 0
        while values_i < len(values):
            value = values[values_i]

            if int(digit / value) >= 1:
                digit -= value
                s += symbols[value]
                continue

            values_i += 1

    return s


if __name__ == "__main__":
    print(convert(3))
