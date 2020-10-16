def convert(s: str) -> int:
    symbols = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    }

    value = 0
    i = 0

    while i < len(s) - 1:
        current = symbols[s[i]]
        peek = symbols[s[i + 1]]

        if peek > current:
            value += peek - current
            i += 2
            continue

        value += current
        i += 1

    if i < len(s):
        value += symbols[s[i]]

    return value

if __name__ == "__main__":
    print(convert("IV"))
