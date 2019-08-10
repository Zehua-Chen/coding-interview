def reverse(x: int) -> int:
    max_int32 = (2 ** (32 - 1)) - 1
    min_int32 = (2 ** (32 - 1)) * -1

    output = 0
    sign = 1 if x > 0 else -1
    x = x if x > 0 else x * -1

    while x >= 10:
        last = x % 10
        x -= last
        x = int(x / 10)

        # use last to compose the new number
        output *= 10
        output += last

        if output > max_int32:
            return 0

    # handle the last digit (the while loop don't)
    output *= 10
    output += x

    output *= sign

    if output > max_int32 or output < min_int32:
        return 0

    return output

if __name__ == "__main__":
    # how to extract numbers from an integer
    value = 123456789

    while value > 10:
        last = value % 10
        value -= last
        value = int(value / 10)

        print("value = {}, last = {}".format(value, last))

    # find the max and min value of a 32 bit int
    max_int32 = (2 ** (32 - 1)) - 1
    print("max int32 = {}".format(max_int32))

    min_int32 = (2 ** (32 - 1)) * -1
    print("min int32 = {}".format(min_int32))
