#  Binary Search

- `left`: left index of the search region
- `right`: right index of the search region
- `mid = (right - left) / 2 + left`

## Base Cases

- `left == right`
- `(right - left) == 1`

Why is `(right - left) == 1` needed? Consider `left = 0`, `right = 1`, `mid = 0`. Without this base case,
`mid = 0` and `right = 1` would repeat `left = 0`, `right = 1`
