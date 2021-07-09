# Table of Contents

- [Table of Contents](#table-of-contents)
- [Overview](#overview)
- [Listening](#listening)
- [Examples](#examples)
- [State a Brute Force](#state-a-brute-force)
- [Optimziation](#optimziation)
- [Implement](#implement)
  - [Specific Ways to Write Good Code](#specific-ways-to-write-good-code)
- [Test](#test)

# Overview

The content of this document supplements the contents of
[Coding Skills](CodingSkills.pdf)

- If you have **heard of the question before**, consider informing your
  interviewer. You won't demonstrate problem solving skills when a solution is
  already known. Some interviewers consider dishonesty a red flag
- **Language**:
  - Abbreviate code while using verbose languages like Java
  - Avoid languages like C++ that lead to hidden problems (pointers, templates)

# Listening

- Retain information about the questions. If a piece of information is not
  useful, it won't be in the question

# Examples

- Give examples that are
  - **Specific**: examples should consist of real data
  - **Sufficiently large**: most examples are too small, by 50%
  - **Not a special case**: special case can be deceiving

# State a Brute Force

- A brute force is a good starting points for discussion and optimization
- If you are stuck, you don't want the interviewer to think that you cannot find
  the easy solution

# Optimziation

In addition to what's included in the infographics:

1. Precompute information
2. Use a hash table
3. Think about conceivable runtime

See more at [Optimizations.md](Optimizations.md)

- Sometimes there is no best solution. It's important to point out the tradeoff
  of different solutions

# Implement

You need to demonstrate that you can write good code. Good code has the
following characteristics

- **Correct**: operate correctly on expected and unexpected inputs
- **Efficient**: operate effeciently in terms of **space and time**.
  - Constant factors dropped in Big O has real life impacts
- **Simple**: 10 lines are better than 100 lines
- **Readable**: a different person should be able to read your code and
  understands its
  - Comments where necessary
  - Implementation is easily understandable
- **Maintainable**: code can be easily changed to adoapt to changes by other
  developers and the initial developer

## Specific Ways to Write Good Code

- Use **data structures** generously
- **Modularize**: break code into smaller units that are
  - Testable
  - Easier to read
- **Flexible and Robust**: unless a general solution is too complicated, derive
  a general solution instead of one that targets only one scenario
- **Good variable names**
  - Abbreviate long variable name after the first usage to save time
- **Error check**: try to write asserts or `if`s or use a "TODO" or explain out
  loud to save time

# Test

- **Conceptual test**: explain what each line does and see if it makes sense
- **Weird looking code**: double check code like `x = length - 2` or `i = 1`
- **Hot spots**: base cases, integer division, null nodes, start and end of a
  linked list, etc.
- **Small test case**
- **Special cases and edge cases**

Make sure to fix bugs in the best way possible.
