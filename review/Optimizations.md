# Table of Contents

- [Table of Contents](#table-of-contents)
- [Technique 1: BUD](#technique-1-bud)
  - [Bottlenecks](#bottlenecks)
  - [Unnecessary Work](#unnecessary-work)
  - [Duplicated Work](#duplicated-work)
- [Technique 2: DIY](#technique-2-diy)
- [Technique 3: Simplify and Generalize](#technique-3-simplify-and-generalize)
  - [Examples](#examples)
- [Technique 4: Base Case and Build](#technique-4-base-case-and-build)
- [Technique 5: Data Structure Brainstorm](#technique-5-data-structure-brainstorm)
- [Best Conceivable Runtime](#best-conceivable-runtime)

# Technique 1: BUD

## Bottlenecks

- One time work that slows down performance. For example, sorting at the
  beginning of the function takes `N log N`, and the rest of the function takes
  `N`. Without optimizing `N log N`, there is no need to optimize `N`
- A chunk of work done repeatedly

## Unnecessary Work

Some work can be skipped. For example, while searcing for answers for a multi
variable equation, the last variable can be directly computed.

## Duplicated Work

Computation results can often be cached.

# Technique 2: DIY

- Use a large example and do the problem by hand, then reverse engineer what you
  have done
- Be aware of the optimization you intuitively or automatically made

# Technique 3: Simplify and Generalize

Simplify the problem, solve the simplified problem and then apply the solution
to the original problem.

## Examples

- [Cracking the Coding Interview 1.7](../problems/strings-arrays/cci-s1-p7/README.md)

# Technique 4: Base Case and Build

Solve the problem for a base case, and then solve more complex problems using
previous solutions

# Technique 5: Data Structure Brainstorm

Try each data structure and see if it make sense for the problem

- Requires practice to develop an instinct

# Best Conceivable Runtime

- Provides hints for optimization
- Let you know when to stop working on runtime complexity and move onto space
  complexity
