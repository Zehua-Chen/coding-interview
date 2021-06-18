# Table of Contents

- [Technique 1: BUD](#BUD)
- [Technique 2: DIY](#DIY)
- [Techqniue 3: Simplify and Generalize](#simplify-generalize)
- [Technique 4: Base Case and Build](#base-case-build)
- [Technique 5: Data Structure Brainstorm](#data-structure-brainstorm)
- [Best Conceivable Runtime](#best-conceivable-runtime)

# Technique 1: BUD <h1 id="BUD">

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

# Technique 2: DIY <span id="DIY">

- Use a large example and do the problem by hand, then reverse engineer what you
  have done
- Be aware of the optimization you intuitively or automatically made

# Technique 3: Simplify and Generalize <span id="simplify-generalize">

Simplify the problem, solve the simplified problem and then apply the solution
to the original problem.

# Technique 4: Base Case and Build <span id="base-case-build">

Solve the problem for a base case, and then solve more complex problems using
previous solutions

# Technique 5: Data Structure Brainstorm <span id="data-structure-brainstorm">

Try each data structure and see if it make sense for the problem

- Requires practice to develop an instinct

# Best Conceivable Runtime <span id="best-conceivable-runtime">

- Provides hints for optimization
- Let you know when to stop working on runtime complexity and move onto space
  complexity
