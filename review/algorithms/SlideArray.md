# Slide Array

To slide array forward, i.e. `[1, 2, 3, x, x, x]` to `[0, 0, 0, 1, 2, 3]`, read
and write from the back (if space permits)

1. `[1, 2, 3, x, x, 3]`
2. `[1, 2, 3, x, 2, 3]`
3. `[1, 2, 3, 1, 2, 3]`
4. `[0, 0, 0, x, 2, 3]`

[URLify](../../problems/strings-arrays/cci-s1-p3/README.md) demonstrates how to
implement this.
