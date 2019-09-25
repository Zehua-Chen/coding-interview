# Budy Tree

Given a complete binary tree with nodes of values of either 1 or 0,
the following rules always hold:
1. A node's value is 1 iff and only if all its subtree nodes' value are 1
2. A leaf node can have value either 1 or 0.

## Task

Implement the following 2 APIs:

setBit(offset, length), set the bits at range from offset to offset + length - 1
clearBits(offset, length), clear the bits at range from offset to offset + length - 1

### Runtime

- O(N), N is the number of bits to clear