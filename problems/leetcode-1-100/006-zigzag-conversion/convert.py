def convert(s: str, numRows: int) -> str:
    # for y to be equal to numRows - 1, numRows must be bigger than 1
    if numRows <= 1:
        return s

    # prepare output buffer
    buffer = ""
    row_buffers = list()

    for i in range(0, numRows):
        row_buffers.append("")

    # populate buffer's content

    step = 1
    y = 0

    for c in s:
        row_buffers[y] += c

        y += step

        if y == 0:
            step = 1
        elif y == numRows - 1:
            step = -1

    for row_buffer in row_buffers:
        buffer += row_buffer

    return buffer

if __name__ == "__main__":
    print(list(range(0, 10)))
