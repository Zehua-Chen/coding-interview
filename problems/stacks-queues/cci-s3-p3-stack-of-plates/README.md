# Cracking the Coding Interview 3.3

**Stack of Plates**
If a stack of plates gets too high, it might topple. Therefore, in real life, we would like to
create a new stack when the previous stack execeeds some threshold. Implement `SetOfStacks` to mimic
this behavior. `SetOfStacks.pop` and `SetOfStacks.push` should mimic the behavior of that of
`Stack`.

## Follow Up

Implement a function `popAt(int index)` which performs a pop operation on a specific sub-stack

## Questions that Should be Asked

- `popAt(int index)` should transfer elements from nearby stacks? (Assumes yes)
