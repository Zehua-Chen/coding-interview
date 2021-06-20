# 7 - Erasing Zeros

You are given a string. Each character is either 0 or 1.

You want all `1`'s in the string to form a contiguous subsegment. For example, if the string is `0`, `1`, `00111` or 
`01111100`, then all `1`'s form a contiguous subsegment, and if the string is `0101`, `100001` or `11111111111101`, 
then this condition is not met.

You may erase some (possibly none) 0's from the string; write a function that calculates the minimum number of `0`'s 
that you have to erase

## Examples

```
input: "0"
output: 0
```

```
input: "010011"
output: 2
```

```
input: "1111000"
output: 0
```