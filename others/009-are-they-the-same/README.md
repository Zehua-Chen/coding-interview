# 9 - Are They the Same

Given two arrays a and b write a function `comp(a, b)` (`compSame(a, b)` in Clojure) that checks whether the two arrays 
have the "same" elements, with the same multiplicities. "Same" means, here, that the elements in b are the elements in 
a squared, regardless of the order.

## Examples

```
input: [], []
output: true
```

```
input: [1, 2, 3], [1, 4 ,9]
output: true
```

```
input: [1, 2, 3], [1, 4 ,1]
output: true
```